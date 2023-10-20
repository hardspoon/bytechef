/*
 * Copyright 2021 <your company/name>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.bytechef.task.dispatcher.sequence.completion;

import com.bytechef.atlas.Constants;
import com.bytechef.atlas.MapObject;
import com.bytechef.atlas.context.domain.Context;
import com.bytechef.atlas.context.domain.MapContext;
import com.bytechef.atlas.coordinator.task.completion.TaskCompletionHandler;
import com.bytechef.atlas.service.context.ContextService;
import com.bytechef.atlas.service.task.execution.TaskExecutionService;
import com.bytechef.atlas.task.dispatcher.TaskDispatcher;
import com.bytechef.atlas.task.execution.TaskStatus;
import com.bytechef.atlas.task.execution.domain.SimpleTaskExecution;
import com.bytechef.atlas.task.execution.domain.TaskExecution;
import com.bytechef.atlas.task.execution.evaluator.TaskEvaluator;
import com.bytechef.atlas.uuid.UUIDGenerator;
import java.util.Date;
import java.util.List;

/**
 * @author Ivica Cardic
 * @author Matija Petanjek
 */
public class SequenceTaskCompletionHandler implements TaskCompletionHandler {

    private final TaskExecutionService taskExecutionService;
    private final TaskCompletionHandler taskCompletionHandler;
    private final TaskDispatcher taskDispatcher;
    private final ContextService contextService;
    private final TaskEvaluator taskEvaluator;

    public SequenceTaskCompletionHandler(
            ContextService contextService,
            TaskCompletionHandler taskCompletionHandler,
            TaskDispatcher taskDispatcher,
            TaskEvaluator taskEvaluator,
            TaskExecutionService taskExecutionService) {
        this.contextService = contextService;
        this.taskCompletionHandler = taskCompletionHandler;
        this.taskDispatcher = taskDispatcher;
        this.taskEvaluator = taskEvaluator;
        this.taskExecutionService = taskExecutionService;
    }

    @Override
    public boolean canHandle(TaskExecution aTaskExecution) {
        String parentId = aTaskExecution.getParentId();

        if (parentId != null) {
            TaskExecution parentTaskExecution = taskExecutionService.getTaskExecution(parentId);

            return parentTaskExecution.getType().equals(Constants.SEQUENCE);
        }

        return false;
    }

    @Override
    public void handle(TaskExecution taskExecution) {
        SimpleTaskExecution completedSubtaskExecution = SimpleTaskExecution.of(taskExecution);

        completedSubtaskExecution.setStatus(TaskStatus.COMPLETED);

        taskExecutionService.merge(completedSubtaskExecution);

        SimpleTaskExecution sequenceTaskExecution =
                SimpleTaskExecution.of(taskExecutionService.getTaskExecution(taskExecution.getParentId()));

        if (taskExecution.getOutput() != null && taskExecution.getName() != null) {
            Context context = contextService.peek(sequenceTaskExecution.getId());

            MapContext newContext = new MapContext(context.asMap());

            newContext.put(taskExecution.getName(), taskExecution.getOutput());

            contextService.push(sequenceTaskExecution.getId(), newContext);
        }

        List<MapObject> subtaskDefinitions = sequenceTaskExecution.getList("tasks", MapObject.class);

        if (taskExecution.getTaskNumber() < subtaskDefinitions.size()) {
            MapObject subtaskDefinition = subtaskDefinitions.get(taskExecution.getTaskNumber());

            SimpleTaskExecution subTaskExecution = SimpleTaskExecution.of(subtaskDefinition);

            subTaskExecution.setCreateTime(new Date());
            subTaskExecution.setId(UUIDGenerator.generate());
            subTaskExecution.setJobId(sequenceTaskExecution.getJobId());
            subTaskExecution.setParentId(sequenceTaskExecution.getId());
            subTaskExecution.setPriority(sequenceTaskExecution.getPriority());
            subTaskExecution.setStatus(TaskStatus.CREATED);
            subTaskExecution.setTaskNumber(taskExecution.getTaskNumber() + 1);

            MapContext context = new MapContext(contextService.peek(sequenceTaskExecution.getId()));

            contextService.push(subTaskExecution.getId(), context);

            TaskExecution evaluatedSubTaskExecution = taskEvaluator.evaluate(subTaskExecution, context);

            taskExecutionService.create(evaluatedSubTaskExecution);
            taskDispatcher.dispatch(evaluatedSubTaskExecution);
        } else {
            sequenceTaskExecution.setEndTime(new Date());
            sequenceTaskExecution.setExecutionTime(
                    sequenceTaskExecution.getEndTime().getTime()
                            - sequenceTaskExecution.getStartTime().getTime());

            taskCompletionHandler.handle(sequenceTaskExecution);
        }
    }
}
