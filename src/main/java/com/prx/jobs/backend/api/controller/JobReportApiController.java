package com.prx.jobs.backend.api.controller;

import com.prx.jobs.backend.api.service.JobReportService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.prx.jobs.backend.util.JobsConstants.JOBS_PATH;

/**
 * This is the JobReportController class.
 * It provides methods for generating job offer reports.
 */
@RestController
@RequestMapping(JOBS_PATH + "/reports")
public class JobReportApiController implements JobReportApi {

    /**
     * The JobReportService object.
     */
    private final JobReportService jobReportService;

    /**
     * This is the constructor for the JobReportController class.
     *
     * @param jobReportService The JobReportService object.
     */
    public JobReportApiController(JobReportService jobReportService) {
        this.jobReportService = jobReportService;
    }

    @Override
    public JobReportService getService() {
        return jobReportService;
    }
}
