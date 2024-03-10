package com.prx.jobs.backend.api.controller;

import com.prx.jobs.backend.api.service.JobOfferService;
import com.prx.jobs.backend.api.to.GetJobOfferResponse;
import com.prx.jobs.backend.api.to.JobOfferContentTO;
import com.prx.jobs.backend.api.to.PostJobOfferRequest;
import com.prx.jobs.backend.api.to.PostJobOfferResponse;
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

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PostJobOfferResponse> postJobOffer(@RequestBody PostJobOfferRequest postJobOfferRequest) {
        return jobOfferService.createJobOffer(postJobOfferRequest);
    }
}
