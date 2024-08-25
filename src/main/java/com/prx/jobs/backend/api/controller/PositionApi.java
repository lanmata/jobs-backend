package com.prx.jobs.backend.api.controller;

import com.prx.jobs.backend.api.service.PositionService;
import com.prx.jobs.backend.api.to.PositionListResponse;
import com.prx.jobs.backend.api.to.PostPositionRequest;
import com.prx.jobs.backend.api.to.SimpleResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.ws.rs.core.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@Tag(name = "positions", description = "The positions API")
public interface PositionApi {

    /**
     * Provides a default implementation of the PositionService.
     * This method returns a new instance of PositionService.
     *
     * @return a new instance of PositionService
     */
    default PositionService getService() {
        return new PositionService() {
        };
    }

    /**
     * List all positions
     *
     * @param includeInactive Include Inactive
     * @return Position List Response
     */
    @Operation(summary = "List all positions",
            description = "Retrieves a list of all positions, optionally including inactive ones.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation",
                    content = @Content(mediaType =  MediaType.APPLICATION_JSON,
                            schema = @Schema(implementation = PositionListResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @GetMapping(produces =  MediaType.APPLICATION_JSON)
    default ResponseEntity<PositionListResponse> list(
            @Parameter(name = "includeInactive", description = "Include inactive positions", required = true)
            @RequestParam(value = "includeInactive") boolean includeInactive) {
        return this.getService().list(includeInactive);
    }

    /**
     * Post a position
     *
     * @param request Post Position Request
     * @return Simple Response
     */
    @Operation(summary = "Post a position",
            description = "Creates a new position with the provided details.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Position created successfully",
                    content = @Content(mediaType =  MediaType.APPLICATION_JSON,
                            schema = @Schema(implementation = SimpleResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @PostMapping(consumes = "application/json", produces =  MediaType.APPLICATION_JSON)
    default ResponseEntity<SimpleResponse> post(
            @Parameter(name = "request", description = "Post Position Request", required = true)
            @RequestBody PostPositionRequest request) {
        return this.getService().save(request);
    }
}
