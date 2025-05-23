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

package com.bytechef.embedded.configuration.service;

import com.bytechef.embedded.configuration.domain.Integration;
import com.bytechef.embedded.configuration.domain.IntegrationVersion;
import com.bytechef.embedded.configuration.domain.IntegrationVersion.Status;
import java.util.List;
import org.springframework.lang.Nullable;

/**
 * @author Ivica Cardic
 */
public interface IntegrationService {

    Integration create(Integration integration);

    void delete(long id);

    Integration getIntegration(long id);

    Integration getIntegrationInstanceIntegration(long integrationInstanceId);

    Integration getIntegrationInstanceConfigurationIntegration(long integrationInstanceConfigurationId);

    List<Integration> getIntegrations();

    List<Integration> getIntegrations(List<Long> ids);

    List<IntegrationVersion> getIntegrationVersions(Long id);

    List<Integration> getIntegrations(
        @Nullable Long categoryId, List<Long> ids, @Nullable Long tagId, @Nullable Status status);

    Integration getWorkflowIntegration(String workflowId);

    int publishIntegration(long id, @Nullable String description);

    Integration update(long id, List<Long> tagIds);

    Integration update(Integration integration);
}
