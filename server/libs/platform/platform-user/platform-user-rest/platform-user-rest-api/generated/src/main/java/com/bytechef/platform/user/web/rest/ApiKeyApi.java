/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.10.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.bytechef.platform.user.web.rest;

import com.bytechef.platform.user.web.rest.model.ApiKeyModel;
import com.bytechef.platform.user.web.rest.model.CreateApiKey200ResponseModel;
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

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-11-26T21:20:00.613241+01:00[Europe/Zagreb]", comments = "Generator version: 7.10.0")
@Validated
@Tag(name = "api-key", description = "The Platform User API Key Internal API")
public interface ApiKeyApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /api-keys : Create a new API key
     * Create a new API key.
     *
     * @param apiKeyModel  (required)
     * @return The secret API key object. (status code 200)
     */
    @Operation(
        operationId = "createApiKey",
        summary = "Create a new API key",
        description = "Create a new API key.",
        tags = { "api-key" },
        responses = {
            @ApiResponse(responseCode = "200", description = "The secret API key object.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = CreateApiKey200ResponseModel.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/api-keys",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    
    default ResponseEntity<CreateApiKey200ResponseModel> createApiKey(
        @Parameter(name = "ApiKeyModel", description = "", required = true) @Valid @RequestBody ApiKeyModel apiKeyModel
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"secretKey\" : \"secretKey\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * DELETE /api-keys/{id} : Delete an API key
     * Delete an API key.
     *
     * @param id The id of an API key. (required)
     * @return Successful operation. (status code 204)
     */
    @Operation(
        operationId = "deleteApiKey",
        summary = "Delete an API key",
        description = "Delete an API key.",
        tags = { "api-key" },
        responses = {
            @ApiResponse(responseCode = "204", description = "Successful operation.")
        }
    )
    @RequestMapping(
        method = RequestMethod.DELETE,
        value = "/api-keys/{id}"
    )
    
    default ResponseEntity<Void> deleteApiKey(
        @Parameter(name = "id", description = "The id of an API key.", required = true, in = ParameterIn.PATH) @PathVariable("id") Long id
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /api-keys/{id} : Get an API key by id
     * Get an API key by id.
     *
     * @param id The id of an API key. (required)
     * @return The API key object. (status code 200)
     */
    @Operation(
        operationId = "getApiKey",
        summary = "Get an API key by id",
        description = "Get an API key by id.",
        tags = { "api-key" },
        responses = {
            @ApiResponse(responseCode = "200", description = "The API key object.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ApiKeyModel.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/api-keys/{id}",
        produces = { "application/json" }
    )
    
    default ResponseEntity<ApiKeyModel> getApiKey(
        @Parameter(name = "id", description = "The id of an API key.", required = true, in = ParameterIn.PATH) @PathVariable("id") Long id
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastUsedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"secretKey\" : \"secretKey\", \"createdBy\" : \"createdBy\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"name\" : \"name\", \"id\" : 0 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /api-keys : Get API keys
     * Get API keys.
     *
     * @return The list of API keys. (status code 200)
     */
    @Operation(
        operationId = "getApiKeys",
        summary = "Get API keys",
        description = "Get API keys.",
        tags = { "api-key" },
        responses = {
            @ApiResponse(responseCode = "200", description = "The list of API keys.", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ApiKeyModel.class)))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/api-keys",
        produces = { "application/json" }
    )
    
    default ResponseEntity<List<ApiKeyModel>> getApiKeys(
        
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastUsedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"secretKey\" : \"secretKey\", \"createdBy\" : \"createdBy\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"name\" : \"name\", \"id\" : 0 }, { \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastUsedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"secretKey\" : \"secretKey\", \"createdBy\" : \"createdBy\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"name\" : \"name\", \"id\" : 0 } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * PUT /api-keys/{id} : Update an existing API key
     * Update an existing API key.
     *
     * @param id The id of an API key. (required)
     * @param apiKeyModel  (required)
     * @return Successful operation. (status code 204)
     */
    @Operation(
        operationId = "updateApiKey",
        summary = "Update an existing API key",
        description = "Update an existing API key.",
        tags = { "api-key" },
        responses = {
            @ApiResponse(responseCode = "204", description = "Successful operation.")
        }
    )
    @RequestMapping(
        method = RequestMethod.PUT,
        value = "/api-keys/{id}",
        consumes = { "application/json" }
    )
    
    default ResponseEntity<Void> updateApiKey(
        @Parameter(name = "id", description = "The id of an API key.", required = true, in = ParameterIn.PATH) @PathVariable("id") Long id,
        @Parameter(name = "ApiKeyModel", description = "", required = true) @Valid @RequestBody ApiKeyModel apiKeyModel
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
