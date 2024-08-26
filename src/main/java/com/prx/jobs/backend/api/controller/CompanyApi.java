package com.prx.jobs.backend.api.controller;

import com.prx.jobs.backend.api.service.CompanyService;
import com.prx.jobs.backend.api.to.CompanyListResponse;
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

/**
 * Interface for the Company API.
 * Provides endpoints for managing companies.
 */
@Tag(name = "companies", description = "The company API")
public interface CompanyApi {

    /**
     * Gets the CompanyService instance.
     *
     * @return a new instance of CompanyService.
     */
    default CompanyService getService() {
        return new CompanyService() {
        };
    }

    @Operation(summary = "Endpoint to list all companies. <p> This method handles HTTP GET requests to retrieve a list " +
            "of companies. It produces a JSON response containing the list of companies.",
            description = "Endpoint to list all companies. <p> This method handles HTTP GET requests to retrieve a list " +
                    "of companies. It produces a JSON response containing the list of companies.", tags = "companies")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation.", content = {
                    @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = CompanyListResponse.class))
            })
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON)
    default ResponseEntity<CompanyListResponse> list(
            @Parameter(name = "includeInactive", description = "Include the companies inactive in the list", required = true)
            @RequestParam(value = "includeInactive") boolean includeInactive) {
        return this.getService().list(includeInactive);
    }
}
