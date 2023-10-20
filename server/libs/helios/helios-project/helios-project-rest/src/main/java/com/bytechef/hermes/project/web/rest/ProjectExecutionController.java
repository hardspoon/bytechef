
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

package com.bytechef.hermes.project.web.rest;

import com.bytechef.autoconfigure.annotation.ConditionalOnApi;
import com.bytechef.hermes.project.facade.ProjectFacade;
import com.bytechef.hermes.project.web.rest.model.ProjectExecutionModel;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

/**
 * @author Ivica Cardic
 */
@RestController
@ConditionalOnApi
@RequestMapping("${openapi.openAPIDefinition.base-path:}")
public class ProjectExecutionController implements ProjectExecutionsApi {

    private final ConversionService conversionService;
    private final ProjectFacade projectFacade;

    @SuppressFBWarnings("EI")
    public ProjectExecutionController(ConversionService conversionService, ProjectFacade projectFacade) {
        this.conversionService = conversionService;
        this.projectFacade = projectFacade;
    }

    @Override
    public Mono<ResponseEntity<Page>> getProjectExecutions(
        String jobStatus, LocalDateTime jobStartTime, LocalDateTime jobEndTime, Long projectId, Long projectInstanceId,
        Long workflowId, Integer pageNumber, ServerWebExchange exchange) {
        return Mono.just(
            ResponseEntity.ok(
                projectFacade
                    .searchProjectExecutions(jobStatus, jobStartTime, jobEndTime, projectId, projectInstanceId,
                        workflowId,
                        pageNumber)
                    .map(
                        projectExecution -> conversionService.convert(projectExecution, ProjectExecutionModel.class))));
    }
}
