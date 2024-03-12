package com.prx.jobs.backend.api.controller;

import com.prx.jobs.backend.api.service.JobOfferService;
import com.prx.jobs.backend.api.to.*;
import jakarta.ws.rs.PathParam;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * The JobOfferController class.
 */
@RestController
@RequestMapping("/v1/job-offers")
public class JobOfferController {

    private final JobOfferService jobOfferService;

    /**
     * The JobOfferController constructor.
     *
     * @param jobOfferService The job offer service.
     */
    public JobOfferController(JobOfferService jobOfferService) {
        this.jobOfferService = jobOfferService;
    }

    /**
     * Finds job offer content by job offer id.
     *
     * @return ResponseEntity<List < JobOfferContentTO>>.
     */
    @GetMapping(path = "/collection", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<JobOfferContentTO>> findJobOfferContent() {
        return jobOfferService.findJobOfferContent();
    }

    /**
     * Finds job offer content by job offer id.
     *
     * @param jobOfferId The job offer id.
     * @return ResponseEntity<GetJobOfferResponse>.
     */
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GetJobOfferResponse>
    getJobOffer(@PathParam("jobOfferId") String jobOfferId) {
        return jobOfferService.findJobOfferContentByJobOfferId(UUID.fromString(jobOfferId));
    }

    /**
     * Posts a job offer.
     *
     * @param postJobOfferRequest The post job offer request.
     * @return ResponseEntity<PostJobOfferResponse>.
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JobOfferResponse> postJobOffer(@RequestBody PostJobOfferRequest postJobOfferRequest) {
        return jobOfferService.createJobOffer(postJobOfferRequest);
    }

    /**
     * Puts a job offer.
     *
     * @param jobOfferId         The job offer id.
     * @param putJobOfferRequest The put job offer request.
     * @return ResponseEntity<JobOfferResponse>.
     */
    @PutMapping(path = "/{jobOfferId}/detail", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PutJobOfferResponse> putJobOffer(@PathVariable("jobOfferId") String jobOfferId, @RequestBody PutJobOfferRequest putJobOfferRequest) {
        return jobOfferService.updateJobOffer(UUID.fromString(jobOfferId), putJobOfferRequest);
    }
}
