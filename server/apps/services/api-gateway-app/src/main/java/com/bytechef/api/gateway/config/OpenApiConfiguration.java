
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

package com.bytechef.api.gateway.config;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.List;
import org.springdoc.core.GroupedOpenApi;
import org.springdoc.core.SwaggerUiConfigParameters;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Ivica Cardic
 */
@Configuration
public class OpenApiConfiguration {

    @Bean
    @SuppressWarnings("PMD.NP")
    @SuppressFBWarnings("NP")
    public List<GroupedOpenApi> apis(
        SwaggerUiConfigParameters swaggerUiConfigParameters, RouteDefinitionLocator locator) {
        List<RouteDefinition> definitions = locator.getRouteDefinitions()
            .collectList()
            .block();

        return definitions.stream()
            .filter(routeDefinition -> routeDefinition.getId()
                .matches(".*-service"))
            .map(routeDefinition -> {
                String name = routeDefinition.getId()
                    .replaceAll("-service", "");

                swaggerUiConfigParameters.addGroup(name);

                return GroupedOpenApi.builder()
                    .pathsToMatch("/" + name + "/**")
                    .group(name)
                    .build();
            })
            .toList();
    }
}
