
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

package com.bytechef.hermes.component.util;

import com.bytechef.atlas.message.broker.TaskMessageRoute;
import com.bytechef.hermes.domain.TriggerExecution;
import com.bytechef.hermes.workflow.WorkflowExecutionId;
import com.bytechef.message.broker.MessageBroker;

/**
 * @author Ivica Cardic
 */
final class ListenerEmitter implements ListenerTriggerUtils.ListenerEmitter {

    private final MessageBroker messageBroker;

    public ListenerEmitter(MessageBroker messageBroker) {
        this.messageBroker = messageBroker;
    }

    @Override
    public void emit(String workflowExecutionId, Object output) {
        TriggerExecution triggerExecution = TriggerExecution.builder()
            .output(output)
            .workflowExecutionId(WorkflowExecutionId.parse(workflowExecutionId))
            .build();

        messageBroker.send(TaskMessageRoute.TASKS_COMPLETIONS, triggerExecution);
    }
}
