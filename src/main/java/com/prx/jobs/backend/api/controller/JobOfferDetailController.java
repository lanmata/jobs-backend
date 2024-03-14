package com.prx.jobs.backend.api.controller;

import com.prx.jobs.backend.api.service.JobOfferDetailService;
import com.prx.jobs.backend.api.to.JobOfferDetailTO;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.PathParam;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

/**
 * The JobOfferDetailController class.
 */
@RestController
@RequestMapping("/v1/job-offer-details")
public class JobOfferDetailController {

    /**
     * The JobOfferDetailService object.
     */
    private final JobOfferDetailService jobOfferDetailService;

    /**
     * Constructor
     *
     * @param jobOfferDetailService The JobOfferDetailService object.
     */
    public JobOfferDetailController(JobOfferDetailService jobOfferDetailService) {
        this.jobOfferDetailService = jobOfferDetailService;
    }

    /**
     * Find post detail by post id.
     *
     * @param jobOfferId The job offer id.
     * @return The list of job offer details.
     */
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<JobOfferDetailTO>> findJobOfferDetailByJobOfferId(
            @PathParam(value = "jobOfferId") @NotNull String jobOfferId) {
        return jobOfferDetailService.findOfferDetailByJobOfferId(UUID.fromString(jobOfferId));
    }

}
