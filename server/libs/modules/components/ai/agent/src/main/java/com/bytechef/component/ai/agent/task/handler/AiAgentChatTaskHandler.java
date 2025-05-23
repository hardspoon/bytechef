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

package com.bytechef.component.ai.agent.task.handler;

import static com.bytechef.component.ai.agent.constant.AiAgentConstants.AI_AGENT;
import static com.bytechef.component.ai.agent.constant.AiAgentConstants.CHAT;

import com.bytechef.platform.component.facade.ActionDefinitionFacade;
import com.bytechef.platform.workflow.worker.task.handler.AbstractTaskHandler;
import org.springframework.stereotype.Component;

/**
 * @author Ivica Cardic
 */
@Component(AI_AGENT + "/v1/" + CHAT)
public class AiAgentChatTaskHandler extends AbstractTaskHandler {

    public AiAgentChatTaskHandler(ActionDefinitionFacade actionDefinitionFacade) {
        super(AI_AGENT, 1, CHAT, actionDefinitionFacade);
    }
}
