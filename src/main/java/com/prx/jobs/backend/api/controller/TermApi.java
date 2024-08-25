package com.prx.jobs.backend.api.controller;

import com.prx.jobs.backend.api.service.TermService;
import com.prx.jobs.backend.api.to.TermListResponse;
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

@Tag(name = "terms", description = "The terms API")
public interface TermApi {

    default TermService getService() {
        return new TermService() {
        };
    }

    /**
     * List all terms
     *
     * @param includeInactive Include Inactive
     * @return Term List Response
     */
    @Operation(summary = "List all terms",
            description = "Retrieves a list of all terms, optionally including inactive ones.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON,
                            schema = @Schema(implementation = TermListResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON)
    default ResponseEntity<TermListResponse> list(
            @Parameter(name = "includeInactive", description = "Include inactive terms", required = true)
            @PathParam(value = "includeInactive") boolean includeInactive) {
        return this.getService().list(includeInactive);
    }
}
