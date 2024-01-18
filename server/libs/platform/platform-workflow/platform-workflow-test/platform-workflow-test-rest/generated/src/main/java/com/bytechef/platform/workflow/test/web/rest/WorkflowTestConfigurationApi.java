/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.2.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.bytechef.platform.workflow.test.web.rest;

import com.bytechef.platform.workflow.test.web.rest.model.UpdateWorkflowTestConfigurationConnectionRequestModel;
import com.bytechef.platform.workflow.test.web.rest.model.UpdateWorkflowTestConfigurationInputsRequestModel;
import com.bytechef.platform.workflow.test.web.rest.model.WorkflowTestConfigurationConnectionModel;
import com.bytechef.platform.workflow.test.web.rest.model.WorkflowTestConfigurationModel;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import jakarta.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-01-18T05:49:36.901615+01:00[Europe/Zagreb]")
@Validated
@Tag(name = "workflow-test-configuration", description = "the workflow-test-configuration API")
public interface WorkflowTestConfigurationApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /workflow-test-configurations : Create a new workflow test configuration.
     * Create a new workflow test configuration.
     *
     * @param workflowTestConfigurationModel  (required)
     * @return The workflow test configuration object. (status code 200)
     */
    @Operation(
        operationId = "createWorkflowTestConfiguration",
        summary = "Create a new workflow test configuration.",
        description = "Create a new workflow test configuration.",
        tags = { "workflow-test-configuration" },
        responses = {
            @ApiResponse(responseCode = "200", description = "The workflow test configuration object.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = WorkflowTestConfigurationModel.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/workflow-test-configurations",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    
    default ResponseEntity<WorkflowTestConfigurationModel> createWorkflowTestConfiguration(
        @Parameter(name = "WorkflowTestConfigurationModel", description = "", required = true) @Valid @RequestBody WorkflowTestConfigurationModel workflowTestConfigurationModel
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"__version\" : 1, \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"inputs\" : { \"key\" : \"{}\" }, \"lastModifiedBy\" : \"lastModifiedBy\", \"id\" : 6, \"connections\" : [ { \"connectionId\" : 0, \"operationName\" : \"operationName\", \"key\" : \"key\" }, { \"connectionId\" : 0, \"operationName\" : \"operationName\", \"key\" : \"key\" } ], \"workflowId\" : \"workflowId\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /workflow-test-configurations/{id} : Get a workflow test configuration
     * Get a workflow test configuration.
     *
     * @param id The id of a workflow test configuration. (required)
     * @return Successful operation. (status code 200)
     */
    @Operation(
        operationId = "getWorkflowTestConfiguration",
        summary = "Get a workflow test configuration",
        description = "Get a workflow test configuration.",
        tags = { "workflow-test-configuration" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = WorkflowTestConfigurationModel.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/workflow-test-configurations/{id}",
        produces = { "application/json" }
    )
    
    default ResponseEntity<WorkflowTestConfigurationModel> getWorkflowTestConfiguration(
        @Parameter(name = "id", description = "The id of a workflow test configuration.", required = true, in = ParameterIn.PATH) @PathVariable("id") Long id
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"__version\" : 1, \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"inputs\" : { \"key\" : \"{}\" }, \"lastModifiedBy\" : \"lastModifiedBy\", \"id\" : 6, \"connections\" : [ { \"connectionId\" : 0, \"operationName\" : \"operationName\", \"key\" : \"key\" }, { \"connectionId\" : 0, \"operationName\" : \"operationName\", \"key\" : \"key\" } ], \"workflowId\" : \"workflowId\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /workflow-test-configurations/{workflowId}/connections/{operationName} : Get a workflow test configuration connections
     * Get a workflow test configuration connections.
     *
     * @param workflowId The id of a testing workflow. (required)
     * @param operationName The action/trigger name defined in the workflow. (required)
     * @return Successful operation. (status code 200)
     */
    @Operation(
        operationId = "getWorkflowTestConfigurationConnections",
        summary = "Get a workflow test configuration connections",
        description = "Get a workflow test configuration connections.",
        tags = { "workflow-test-configuration" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation.", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = WorkflowTestConfigurationConnectionModel.class)))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/workflow-test-configurations/{workflowId}/connections/{operationName}",
        produces = { "application/json" }
    )
    
    default ResponseEntity<List<WorkflowTestConfigurationConnectionModel>> getWorkflowTestConfigurationConnections(
        @Parameter(name = "workflowId", description = "The id of a testing workflow.", required = true, in = ParameterIn.PATH) @PathVariable("workflowId") String workflowId,
        @Parameter(name = "operationName", description = "The action/trigger name defined in the workflow.", required = true, in = ParameterIn.PATH) @PathVariable("operationName") String operationName
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"connectionId\" : 0, \"operationName\" : \"operationName\", \"key\" : \"key\" }, { \"connectionId\" : 0, \"operationName\" : \"operationName\", \"key\" : \"key\" } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /workflow-test-configurations : Get all workflow test configurations
     * Get all workflow test configurations.
     *
     * @return Successful operation. (status code 200)
     */
    @Operation(
        operationId = "getWorkflowTestConfigurations",
        summary = "Get all workflow test configurations",
        description = "Get all workflow test configurations.",
        tags = { "workflow-test-configuration" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation.", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = WorkflowTestConfigurationModel.class)))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/workflow-test-configurations",
        produces = { "application/json" }
    )
    
    default ResponseEntity<List<WorkflowTestConfigurationModel>> getWorkflowTestConfigurations(
        
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"__version\" : 1, \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"inputs\" : { \"key\" : \"{}\" }, \"lastModifiedBy\" : \"lastModifiedBy\", \"id\" : 6, \"connections\" : [ { \"connectionId\" : 0, \"operationName\" : \"operationName\", \"key\" : \"key\" }, { \"connectionId\" : 0, \"operationName\" : \"operationName\", \"key\" : \"key\" } ], \"workflowId\" : \"workflowId\" }, { \"__version\" : 1, \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"inputs\" : { \"key\" : \"{}\" }, \"lastModifiedBy\" : \"lastModifiedBy\", \"id\" : 6, \"connections\" : [ { \"connectionId\" : 0, \"operationName\" : \"operationName\", \"key\" : \"key\" }, { \"connectionId\" : 0, \"operationName\" : \"operationName\", \"key\" : \"key\" } ], \"workflowId\" : \"workflowId\" } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * PUT /workflow-test-configurations/{id} : Update an existing workflow test configuration
     * Update an existing workflow test configuration.
     *
     * @param id The id of a workflow test configuration. (required)
     * @param workflowTestConfigurationModel  (required)
     * @return The updated workflow test configuration object. (status code 200)
     */
    @Operation(
        operationId = "updateWorkflowTestConfiguration",
        summary = "Update an existing workflow test configuration",
        description = "Update an existing workflow test configuration.",
        tags = { "workflow-test-configuration" },
        responses = {
            @ApiResponse(responseCode = "200", description = "The updated workflow test configuration object.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = WorkflowTestConfigurationModel.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.PUT,
        value = "/workflow-test-configurations/{id}",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    
    default ResponseEntity<WorkflowTestConfigurationModel> updateWorkflowTestConfiguration(
        @Parameter(name = "id", description = "The id of a workflow test configuration.", required = true, in = ParameterIn.PATH) @PathVariable("id") Long id,
        @Parameter(name = "WorkflowTestConfigurationModel", description = "", required = true) @Valid @RequestBody WorkflowTestConfigurationModel workflowTestConfigurationModel
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"__version\" : 1, \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"inputs\" : { \"key\" : \"{}\" }, \"lastModifiedBy\" : \"lastModifiedBy\", \"id\" : 6, \"connections\" : [ { \"connectionId\" : 0, \"operationName\" : \"operationName\", \"key\" : \"key\" }, { \"connectionId\" : 0, \"operationName\" : \"operationName\", \"key\" : \"key\" } ], \"workflowId\" : \"workflowId\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * PUT /workflow-test-configurations/{workflowId}/connections/{operationName}/{key} : Update a workflow test configuration connection
     * Update a workflow test configuration connection.
     *
     * @param workflowId The id of a testing workflow. (required)
     * @param operationName The action/trigger name defined in the workflow. (required)
     * @param key The key of a connection. (required)
     * @param updateWorkflowTestConfigurationConnectionRequestModel  (required)
     * @return Successful operation. (status code 200)
     */
    @Operation(
        operationId = "updateWorkflowTestConfigurationConnection",
        summary = "Update a workflow test configuration connection",
        description = "Update a workflow test configuration connection.",
        tags = { "workflow-test-configuration" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation.")
        }
    )
    @RequestMapping(
        method = RequestMethod.PUT,
        value = "/workflow-test-configurations/{workflowId}/connections/{operationName}/{key}",
        consumes = { "application/json" }
    )
    
    default ResponseEntity<Void> updateWorkflowTestConfigurationConnection(
        @Parameter(name = "workflowId", description = "The id of a testing workflow.", required = true, in = ParameterIn.PATH) @PathVariable("workflowId") String workflowId,
        @Parameter(name = "operationName", description = "The action/trigger name defined in the workflow.", required = true, in = ParameterIn.PATH) @PathVariable("operationName") String operationName,
        @Parameter(name = "key", description = "The key of a connection.", required = true, in = ParameterIn.PATH) @PathVariable("key") String key,
        @Parameter(name = "UpdateWorkflowTestConfigurationConnectionRequestModel", description = "", required = true) @Valid @RequestBody UpdateWorkflowTestConfigurationConnectionRequestModel updateWorkflowTestConfigurationConnectionRequestModel
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * PUT /workflow-test-configurations/{workflowId}/inputs : Update a workflow test configuration inputs
     * Update a workflow test configuration inputs.
     *
     * @param workflowId The id of a testing workflow. (required)
     * @param updateWorkflowTestConfigurationInputsRequestModel  (required)
     * @return Successful operation. (status code 200)
     */
    @Operation(
        operationId = "updateWorkflowTestConfigurationInputs",
        summary = "Update a workflow test configuration inputs",
        description = "Update a workflow test configuration inputs.",
        tags = { "workflow-test-configuration" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation.")
        }
    )
    @RequestMapping(
        method = RequestMethod.PUT,
        value = "/workflow-test-configurations/{workflowId}/inputs",
        consumes = { "application/json" }
    )
    
    default ResponseEntity<Void> updateWorkflowTestConfigurationInputs(
        @Parameter(name = "workflowId", description = "The id of a testing workflow.", required = true, in = ParameterIn.PATH) @PathVariable("workflowId") String workflowId,
        @Parameter(name = "UpdateWorkflowTestConfigurationInputsRequestModel", description = "", required = true) @Valid @RequestBody UpdateWorkflowTestConfigurationInputsRequestModel updateWorkflowTestConfigurationInputsRequestModel
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
