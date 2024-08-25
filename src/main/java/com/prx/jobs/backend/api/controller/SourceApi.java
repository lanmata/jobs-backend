package com.prx.jobs.backend.api.controller;

import com.prx.jobs.backend.api.service.SourceService;
import com.prx.jobs.backend.api.to.SourceListResponse;
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

@Tag(name = "sources", description = "The source API")
public interface SourceApi {

    default SourceService getService() {
        return new SourceService() {
        };
    }

    /**
     * List all companies
     *
     * @param includeInactive Include Inactive
     * @return Company List Response
     */
    @Operation(summary = "List all companies",
               description = "Retrieves a list of all companies, optionally including inactive ones.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successful operation",
                     content = @Content(mediaType = MediaType.APPLICATION_JSON,
                                        schema = @Schema(implementation = SourceListResponse.class))),
        @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON)
    default ResponseEntity<SourceListResponse> list(
            @Parameter(name = "includeInactive", description = "Include inactive companies", required = true)
            @PathParam(value = "includeInactive") boolean includeInactive) {
        return this.getService().list(includeInactive);
    }
}
