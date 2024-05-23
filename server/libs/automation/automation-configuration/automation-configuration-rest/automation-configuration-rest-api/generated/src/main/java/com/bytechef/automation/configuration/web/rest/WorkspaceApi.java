/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.5.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.bytechef.automation.configuration.web.rest;

import com.bytechef.automation.configuration.web.rest.model.WorkspaceModel;
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

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-05-23T10:43:27.360237+02:00[Europe/Zagreb]", comments = "Generator version: 7.5.0")
@Validated
@Tag(name = "workspace", description = "The Automation Workspace API")
public interface WorkspaceApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /workspaces : Create a new workspace
     * Create a workspace event.
     *
     * @param workspaceModel  (required)
     * @return The workspace object. (status code 200)
     */
    @Operation(
        operationId = "createWorkspace",
        summary = "Create a new workspace",
        description = "Create a workspace event.",
        tags = { "workspace" },
        responses = {
            @ApiResponse(responseCode = "200", description = "The workspace object.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = WorkspaceModel.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/workspaces",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    
    default ResponseEntity<WorkspaceModel> createWorkspace(
        @Parameter(name = "WorkspaceModel", description = "", required = true) @Valid @RequestBody WorkspaceModel workspaceModel
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"__version\" : 6, \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"name\" : \"name\", \"description\" : \"description\", \"id\" : 0 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * DELETE /workspaces/{id} : Delete a workspace
     * Delete a workspace.
     *
     * @param id The id of a workspace. (required)
     * @return Successful operation. (status code 200)
     */
    @Operation(
        operationId = "deleteWorkspace",
        summary = "Delete a workspace",
        description = "Delete a workspace.",
        tags = { "workspace" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation.")
        }
    )
    @RequestMapping(
        method = RequestMethod.DELETE,
        value = "/workspaces/{id}"
    )
    
    default ResponseEntity<Void> deleteWorkspace(
        @Parameter(name = "id", description = "The id of a workspace.", required = true, in = ParameterIn.PATH) @PathVariable("id") Long id
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /workspaces/{id} : Get a workspace by id
     * Get a workspace by id.
     *
     * @param id The id of a workspace. (required)
     * @return The workspace object. (status code 200)
     */
    @Operation(
        operationId = "getWorkspace",
        summary = "Get a workspace by id",
        description = "Get a workspace by id.",
        tags = { "workspace" },
        responses = {
            @ApiResponse(responseCode = "200", description = "The workspace object.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = WorkspaceModel.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/workspaces/{id}",
        produces = { "application/json" }
    )
    
    default ResponseEntity<WorkspaceModel> getWorkspace(
        @Parameter(name = "id", description = "The id of a workspace.", required = true, in = ParameterIn.PATH) @PathVariable("id") Long id
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"__version\" : 6, \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"name\" : \"name\", \"description\" : \"description\", \"id\" : 0 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /workspaces : Get workspaces
     * Get workspaces.
     *
     * @return A list of workspaces. (status code 200)
     */
    @Operation(
        operationId = "getWorkspaces",
        summary = "Get workspaces",
        description = "Get workspaces.",
        tags = { "workspace" },
        responses = {
            @ApiResponse(responseCode = "200", description = "A list of workspaces.", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = WorkspaceModel.class)))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/workspaces",
        produces = { "application/json" }
    )
    
    default ResponseEntity<List<WorkspaceModel>> getWorkspaces(
        
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"__version\" : 6, \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"name\" : \"name\", \"description\" : \"description\", \"id\" : 0 }, { \"__version\" : 6, \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"name\" : \"name\", \"description\" : \"description\", \"id\" : 0 } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * PUT /workspaces/{id}/projects : Update an existing workspace
     * Update an existing workspace.
     *
     * @param id The id of a workspace. (required)
     * @param workspaceModel  (required)
     * @return The updated workspace object. (status code 200)
     */
    @Operation(
        operationId = "updateWorkspace",
        summary = "Update an existing workspace",
        description = "Update an existing workspace.",
        tags = { "workspace" },
        responses = {
            @ApiResponse(responseCode = "200", description = "The updated workspace object.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = WorkspaceModel.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.PUT,
        value = "/workspaces/{id}/projects",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    
    default ResponseEntity<WorkspaceModel> updateWorkspace(
        @Parameter(name = "id", description = "The id of a workspace.", required = true, in = ParameterIn.PATH) @PathVariable("id") Long id,
        @Parameter(name = "WorkspaceModel", description = "", required = true) @Valid @RequestBody WorkspaceModel workspaceModel
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"__version\" : 6, \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"name\" : \"name\", \"description\" : \"description\", \"id\" : 0 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}