package com.prx.jobs.backend.api.controller;

import com.prx.jobs.backend.api.service.StatusService;
import com.prx.jobs.backend.api.to.StatusListResponse;
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

@Tag(name = "status", description = "The status API")
public interface StatusApi {

    default StatusService getService() {
        return new StatusService() {
        };
    }

    /**
     * List all statuses
     *
     * @param includeInactive Include Inactive
     * @return Status List Response
     */
    @Operation(summary = "List all statuses",
            description = "Retrieves a list of all statuses, optionally including inactive ones.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON,
                            schema = @Schema(implementation = StatusListResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON)
    default ResponseEntity<StatusListResponse> list(
            @Parameter(name = "includeInactive", description = "Include inactive statuses", required = true)
            @PathParam(value = "includeInactive") boolean includeInactive) {
        return this.getService().list(includeInactive);
    }
}
