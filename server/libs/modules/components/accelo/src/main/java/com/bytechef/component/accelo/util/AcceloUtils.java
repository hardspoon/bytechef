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

package com.bytechef.component.accelo.util;

import static com.bytechef.component.accelo.constant.AcceloConstants.AGAINST_TYPE;
import static com.bytechef.component.accelo.constant.AcceloConstants.ID;
import static com.bytechef.component.accelo.constant.AcceloConstants.TITLE;
import static com.bytechef.component.definition.ComponentDsl.option;

import com.bytechef.component.definition.ActionContext;
import com.bytechef.component.definition.Context;
import com.bytechef.component.definition.Context.Http;
import com.bytechef.component.definition.Option;
import com.bytechef.component.definition.Parameters;
import com.bytechef.component.definition.TypeReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author Monika Kušter
 */
public class AcceloUtils extends AbstractAcceloUtils {

    private AcceloUtils() {
    }

    public static List<Option<String>> getAgainstIdOptions(
        Parameters inputParameters, Parameters connectionParameters, Map<String, String> lookupDependsOnPaths,
        String searchText, ActionContext context) {

        String againstType = inputParameters.getRequiredString(AGAINST_TYPE);

        if (Objects.equals("company", againstType)) {
            return getCompanyIdOptions(inputParameters, connectionParameters, lookupDependsOnPaths, searchText,
                context);
        } else {
            Map<String, ?> body = context
                .http(http -> http.get(againstType + "s"))
                .configuration(Http.responseType(Http.ResponseType.JSON))
                .execute()
                .getBody(new TypeReference<>() {});

            List<Option<String>> options = new ArrayList<>();

            if (body.get("response") instanceof List<?> list) {
                for (Object item : list) {
                    if (item instanceof Map<?, ?> map) {
                        options.add(option((String) map.get(TITLE), (String) map.get(ID)));
                    }
                }
            }

            return options;
        }
    }

    public static List<Option<String>> getCompanyIdOptions(
        Parameters inputParameters, Parameters connectionParameters, Map<String, String> lookupDependsOnPaths,
        String searchText, Context context) {

        Map<String, ?> body = context
            .http(http -> http.get("companies"))
            .configuration(Http.responseType(Http.ResponseType.JSON))
            .execute()
            .getBody(new TypeReference<>() {});

        List<Option<String>> options = new ArrayList<>();

        if (body.get("response") instanceof List<?> list) {
            for (Object item : list) {
                if (item instanceof Map<?, ?> map) {
                    options.add(option((String) map.get("name"), (String) map.get(ID)));
                }
            }
        }

        return options;
    }
}
