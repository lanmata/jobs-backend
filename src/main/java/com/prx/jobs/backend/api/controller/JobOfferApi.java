package com.prx.jobs.backend.api.controller;

import com.prx.jobs.backend.api.service.JobOfferService;
import com.prx.jobs.backend.api.to.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "job-offers", description = "The Job Offers API")
public interface JobOfferApi {

    default JobOfferService getService() {
        return new JobOfferService() {};
    }

    @Operation(summary = "Finds job offer content by job offer id",
               description = "Retrieves a list of job offer content.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successful operation",
                     content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                                        schema = @Schema(implementation = JobOfferContentTO.class))),
        @ApiResponse(responseCode = "404", description = "Job offer content not found")
    })
    @GetMapping(path = "/collection", produces = MediaType.APPLICATION_JSON_VALUE)
    default ResponseEntity<List<JobOfferContentTO>> findJobOfferContent() {
        return this.getService().findJobOfferContent();
    }

    @Operation(summary = "Finds job offer by id",
               description = "Retrieves a job offer by its id.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successful operation",
                     content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                                        schema = @Schema(implementation = GetJobOfferResponse.class))),
        @ApiResponse(responseCode = "404", description = "Job offer not found")
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    default ResponseEntity<GetJobOfferResponse> getJobOffer(
            @Parameter(name = "jobOfferId", description = "The job offer id", required = true)
            @RequestParam("jobOfferId") String jobOfferId) {
        return this.getService().findJobOfferContentByJobOfferId(UUID.fromString(jobOfferId));
    }

    @Operation(summary = "Posts a job offer",
               description = "Creates a new job offer.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Job offer created",
                     content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                                        schema = @Schema(implementation = PostJobOfferResponse.class))),
        @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    default ResponseEntity<PostJobOfferResponse> postJobOffer(
            @Parameter(name = "postJobOfferRequest", description = "The post job offer request", required = true)
            @RequestBody PostJobOfferRequest postJobOfferRequest) {
        return this.getService().createJobOffer(postJobOfferRequest);
    }

    @Operation(summary = "Puts a job offer",
               description = "Updates an existing job offer.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Job offer updated",
                     content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                                        schema = @Schema(implementation = PutJobOfferResponse.class))),
        @ApiResponse(responseCode = "404", description = "Job offer not found"),
        @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @PutMapping(path = "/{id}/detail", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    default ResponseEntity<PutJobOfferResponse> putJobOffer(
            @Parameter(name = "jobOfferId", description = "The job offer id", required = true)
            @PathVariable(value = "id") String jobOfferId,
            @Parameter(name = "putJobOfferRequest", description = "The put job offer request", required = true)
            @RequestBody PutJobOfferRequest putJobOfferRequest) {
        return this.getService().updateJobOffer(UUID.fromString(jobOfferId), putJobOfferRequest);
    }
}
