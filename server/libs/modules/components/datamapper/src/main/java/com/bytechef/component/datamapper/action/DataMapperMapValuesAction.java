
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

package com.bytechef.component.datamapper.action;

import com.bytechef.hermes.component.ActionContext;
import com.bytechef.hermes.component.definition.ActionDefinition;
import com.bytechef.hermes.component.definition.ComponentDSL;

import java.util.Map;

import static com.bytechef.hermes.definition.DefinitionDSL.array;

import static com.bytechef.hermes.definition.DefinitionDSL.object;
import static com.bytechef.hermes.definition.DefinitionDSL.oneOf;
import static com.bytechef.hermes.definition.DefinitionDSL.string;

/**
 * @author Ivica Cardic
 */
public class DataMapperMapValuesAction {

    private static final String INPUT = "input";
    private static final String MAPPINGS = "mappings";

    public static final ActionDefinition ACTION_DEFINITION = ComponentDSL.action("mapValues")
        .title("Map values")
        .description(
            "When provided with an object or an array of objects, the function maps one or more values to new values. It can be restricted to specific keys of the object. The resulting data structure is a new object or array with the original structure and updated values.")
        .properties(
            oneOf(INPUT)
                .label("Input")
                .description("Object containing one or more properties.")
                .types(object(), array())
                .required(true),
            array(MAPPINGS)
                .label("Mappings")
                .description(
                    "Specify the necessary mappings by defining that \"From\" refers to a particular key from the Input, while \"To\" represents the name of a new key that is assigned the corresponding value of the \"From\" key.")
                .items(
                    object().properties(
                        string("from")
                            .label("From"),
                        string("to")
                            .label("To")))
                .required(true))
        .execute(DataMapperMapValuesAction::execute);

    protected static Object execute(ActionContext context, Map<String, ?> inputParameters) {
        return null;
    }
}
