package com.prx.jobs.backend.api.controller;

import com.prx.jobs.backend.api.service.JobOfferDetailService;
import com.prx.jobs.backend.api.to.JobOfferDetailTO;
import com.prx.jobs.backend.api.to.SimpleResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.PathParam;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

@Tag(name = "job-offers", description = "The Job Offers API")
public interface JobOfferDetailApi {

    default JobOfferDetailService getService() {
        return new JobOfferDetailService() {
        };
    }

    /**
     * Find post detail by post id.
     *
     * @param jobOfferId The job offer id.
     * @return The list of job offer details.
     */
    @Operation(summary = "Find job offer detail by job offer id",
            description = "Retrieves the details of a job offer by its ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = JobOfferDetailTO.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    default ResponseEntity<List<JobOfferDetailTO>> findJobOfferDetailByJobOfferId(
            @Parameter(name = "jobOfferId", description = "The job offer id", required = true)
            @PathParam(value = "jobOfferId") @NotNull String jobOfferId) {
        return this.getService().findOfferDetailByJobOfferId(UUID.fromString(jobOfferId));
    }

    /**
     * Delete job offer detail.
     *
     * @param jobOfferDetailId The job offer detail id.
     * @return The simple response.
     */
    @Operation(summary = "Delete job offer detail",
            description = "Deletes a job offer detail by its ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = SimpleResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @DeleteMapping(produces = {MediaType.APPLICATION_JSON_VALUE}, path = "/{jobOfferDetailId}")
    default ResponseEntity<SimpleResponse> deleteOfferDetail(
            @Parameter(name = "jobOfferDetailId", description = "The job offer detail id", required = true)
            @PathVariable(value = "jobOfferDetailId") @NotNull String jobOfferDetailId) {
        return this.getService().deleteOfferDetail(UUID.fromString(jobOfferDetailId));
    }


}
