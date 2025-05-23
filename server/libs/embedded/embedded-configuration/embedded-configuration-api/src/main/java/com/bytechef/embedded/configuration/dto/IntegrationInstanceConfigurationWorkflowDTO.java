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

package com.bytechef.embedded.configuration.dto;

import com.bytechef.atlas.configuration.domain.Workflow;
import com.bytechef.embedded.configuration.domain.IntegrationInstanceConfigurationWorkflow;
import com.bytechef.embedded.configuration.domain.IntegrationInstanceConfigurationWorkflowConnection;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.time.Instant;
import java.util.List;
import java.util.Map;

/**
 * @author Ivica Cardic
 */
@SuppressFBWarnings("EI")
public record IntegrationInstanceConfigurationWorkflowDTO(
    List<IntegrationInstanceConfigurationWorkflowConnection> connections, String createdBy, Instant createdDate,
    Map<String, ?> inputs, boolean enabled, Long id, Instant lastExecutionDate, String lastModifiedBy,
    Instant lastModifiedDate, Long integrationInstanceConfigurationId, int version, Workflow workflow,
    String workflowId, String workflowReferenceCode)
    implements Comparable<IntegrationInstanceConfigurationWorkflowDTO> {

    public IntegrationInstanceConfigurationWorkflowDTO(
        IntegrationInstanceConfigurationWorkflow integrationInstanceConfigurationWorkflow, Instant lastExecutionDate,
        Workflow workflow, String workflowReferenceCode) {

        this(
            integrationInstanceConfigurationWorkflow.getConnections(),
            integrationInstanceConfigurationWorkflow.getCreatedBy(),
            integrationInstanceConfigurationWorkflow.getCreatedDate(),
            integrationInstanceConfigurationWorkflow.getInputs(),
            integrationInstanceConfigurationWorkflow.isEnabled(),
            integrationInstanceConfigurationWorkflow.getId(),
            lastExecutionDate, integrationInstanceConfigurationWorkflow.getLastModifiedBy(),
            integrationInstanceConfigurationWorkflow.getLastModifiedDate(),
            integrationInstanceConfigurationWorkflow.getIntegrationInstanceConfigurationId(),
            integrationInstanceConfigurationWorkflow.getVersion(), workflow,
            integrationInstanceConfigurationWorkflow.getWorkflowId(), workflowReferenceCode);
    }

    @Override
    public int compareTo(IntegrationInstanceConfigurationWorkflowDTO integrationInstanceConfigurationWorkflowDTO) {
        return workflowId.compareTo(integrationInstanceConfigurationWorkflowDTO.workflowId);
    }

    public IntegrationInstanceConfigurationWorkflow toIntegrationInstanceConfigurationWorkflow() {
        IntegrationInstanceConfigurationWorkflow integrationInstanceConfigurationWorkflow =
            new IntegrationInstanceConfigurationWorkflow();

        integrationInstanceConfigurationWorkflow.setConnections(connections);
        integrationInstanceConfigurationWorkflow.setEnabled(enabled);
        integrationInstanceConfigurationWorkflow.setId(id);
        integrationInstanceConfigurationWorkflow.setInputs(inputs);
        integrationInstanceConfigurationWorkflow.setVersion(version);
        integrationInstanceConfigurationWorkflow.setWorkflowId(workflowId);

        return integrationInstanceConfigurationWorkflow;
    }
}
