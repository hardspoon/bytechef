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

package com.bytechef.component.freshsales.action;

import static com.bytechef.component.definition.ComponentDsl.action;
import static com.bytechef.component.definition.ComponentDsl.number;
import static com.bytechef.component.definition.ComponentDsl.object;
import static com.bytechef.component.definition.ComponentDsl.outputSchema;
import static com.bytechef.component.definition.ComponentDsl.string;
import static com.bytechef.component.freshsales.constant.FreshsalesConstants.EMAIL;
import static com.bytechef.component.freshsales.constant.FreshsalesConstants.FIRST_NAME;
import static com.bytechef.component.freshsales.constant.FreshsalesConstants.ID;
import static com.bytechef.component.freshsales.constant.FreshsalesConstants.LAST_NAME;

import com.bytechef.component.definition.ActionContext;
import com.bytechef.component.definition.ComponentDsl.ModifiableActionDefinition;
import com.bytechef.component.definition.Context.Http;
import com.bytechef.component.definition.Parameters;
import com.bytechef.component.definition.Property.ControlType;
import com.bytechef.component.definition.TypeReference;

/**
 * @author Monika Domiter
 */
public class FreshsalesCreateLeadAction {

    public static final ModifiableActionDefinition ACTION_DEFINITION = action("createLead")
        .title("Create Lead")
        .description("Creates a new lead.")
        .properties(
            string(FIRST_NAME)
                .label("First Name")
                .description("First name of the lead.")
                .required(false),
            string(LAST_NAME)
                .label("Last Name")
                .description("Last name of the lead.")
                .required(false),
            string(EMAIL)
                .label("Email")
                .description("Primary email address of the lead.")
                .controlType(ControlType.EMAIL)
                .required(true))
        .output(
            outputSchema(
                object()
                    .properties(
                        object("lead")
                            .properties(
                                number(ID)
                                    .description("ID of the lead."),
                                string(EMAIL)
                                    .description("Primary email address of the lead."),
                                string(FIRST_NAME)
                                    .description("First name of the lead."),
                                string(LAST_NAME)
                                    .description("Last name of the lead.")))))
        .perform(FreshsalesCreateLeadAction::perform);

    private FreshsalesCreateLeadAction() {
    }

    public static Object perform(
        Parameters inputParameters, Parameters connectionParameters, ActionContext actionContext) {

        return actionContext.http(http -> http.post("/leads"))
            .body(
                Http.Body.of(
                    FIRST_NAME, inputParameters.getString(FIRST_NAME),
                    LAST_NAME, inputParameters.getString(LAST_NAME),
                    EMAIL, inputParameters.getRequiredString(EMAIL)))
            .configuration(Http.responseType(Http.ResponseType.JSON))
            .execute()
            .getBody(new TypeReference<>() {});

    }
}
