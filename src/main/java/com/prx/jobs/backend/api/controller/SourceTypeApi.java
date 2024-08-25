package com.prx.jobs.backend.api.controller;

import com.prx.jobs.backend.api.service.SourceTypeService;
import com.prx.jobs.backend.api.to.SourceTypeListResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@Tag(name = "sources-types", description = "The source types API")
public interface SourceTypeApi {

    default SourceTypeService getService() {
        return new SourceTypeService() {
        };
    }

    /**
     * List all source types
     *
     * @param includeInactive Include Inactive
     * @return SourceType List Response
     */
    @Operation(summary = "List all source types",
            description = "Retrieves a list of all source types, optionally including inactive ones.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON,
                            schema = @Schema(implementation = SourceTypeListResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON)
    default ResponseEntity<SourceTypeListResponse> list(
            @Parameter(name = "includeInactive", description = "Include inactive source types", required = true)
            @PathParam(value = "includeInactive") boolean includeInactive) {
        return this.getService().list(includeInactive);
    }
}
