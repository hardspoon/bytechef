/*
 * Copyright 2025 ByteChef
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

package com.bytechef.component.datastream.task.handler;

import static com.bytechef.component.datastream.constant.DataStreamConstants.DATA_STREAM;
import static com.bytechef.component.datastream.constant.DataStreamConstants.STREAM;

import com.bytechef.platform.component.facade.ActionDefinitionFacade;
import com.bytechef.platform.workflow.worker.task.handler.AbstractTaskHandler;
import org.springframework.stereotype.Component;

/**
 * @author Ivica Cardic
 */
@Component(DATA_STREAM + "/v1/stream")
public class DataStreamStreamTaskHandler extends AbstractTaskHandler {

    public DataStreamStreamTaskHandler(ActionDefinitionFacade actionDefinitionFacade) {
        super(DATA_STREAM, 1, STREAM, actionDefinitionFacade);
    }
}
