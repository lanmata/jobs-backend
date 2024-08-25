package com.prx.jobs.backend.api.controller;

import com.prx.jobs.backend.api.service.JobOfferDetailService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.prx.jobs.backend.util.JobsConstants.JOBS_PATH;

/**
 * The JobOfferDetailController class.
 */
@RestController
@RequestMapping(JOBS_PATH + "/job-offer-details")
public class JobOfferDetailApiController implements JobOfferDetailApi {

    /**
     * The JobOfferDetailService object.
     */
    private final JobOfferDetailService jobOfferDetailService;

    /**
     * Constructor
     *
     * @param jobOfferDetailService The JobOfferDetailService object.
     */
    public JobOfferDetailApiController(JobOfferDetailService jobOfferDetailService) {
        this.jobOfferDetailService = jobOfferDetailService;
    }

    @Override
    public JobOfferDetailService getService() {
        return this.jobOfferDetailService;
    }
}
