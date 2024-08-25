package com.prx.jobs.backend.api.controller;

import com.prx.jobs.backend.api.service.JobOfferService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.prx.jobs.backend.util.JobsConstants.JOBS_PATH;

/**
 * The JobOfferController class.
 * This class handles HTTP requests related to job offers.
 */
@RestController
@RequestMapping(JOBS_PATH + "/job-offers")
public class JobOfferApiController implements JobOfferApi{

    private final JobOfferService jobOfferService;

    /**
     * The JobOfferController constructor.
     *
     * @param jobOfferService The job offer service.
     */
    public JobOfferApiController(JobOfferService jobOfferService) {
        this.jobOfferService = jobOfferService;
    }

    /**
     * Gets the job offer service.
     *
     * @return The job offer service.
     */
    @Override
    public JobOfferService getService() {
        return this.jobOfferService;
    }
}
