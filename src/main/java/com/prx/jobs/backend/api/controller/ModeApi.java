package com.prx.jobs.backend.api.controller;

import com.prx.jobs.backend.api.service.ModeService;
import com.prx.jobs.backend.api.to.ModeListResponse;
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
import org.springframework.web.bind.annotation.RequestParam;

@Tag(name = "modes", description = "The Modes API")
public interface ModeApi {

    /**
     * Gets the mode service.
     *
     * @return The mode service.
     */
    default ModeService getService() {
        return new ModeService() {
        };
    }

    /**
     * List all modes.
     *
     * @param includeInactive Include Inactive
     * @return Mode List Response
     */
    @Operation(summary = "List all modes",
            description = "Retrieves a list of all modes, optionally including inactive ones.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON,
                            schema = @Schema(implementation = ModeListResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON)
    default ResponseEntity<ModeListResponse> list(
            @Parameter(name = "includeInactive", description = "Include inactive modes", required = true)
            @RequestParam(value = "includeInactive") boolean includeInactive) {
        return this.getService().list(includeInactive);
    }
}
