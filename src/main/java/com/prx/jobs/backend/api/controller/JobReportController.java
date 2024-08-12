package com.prx.jobs.backend.api.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.prx.jobs.backend.api.service.JobReportService;
import jakarta.ws.rs.PathParam;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

import static com.prx.commons.util.DateUtil.PATTERN_DATE_TIME;
import static com.prx.jobs.backend.util.JobsConstants.JOBS_PATH;

/**
 * This is the JobReportController class.
 * It provides methods for generating job offer reports.
 */
@RestController
@RequestMapping(JOBS_PATH + "/reports")
public class JobReportController {

    /**
     * The JobReportService object.
     */
    private final JobReportService jobReportService;

    /**
     * This is the constructor for the JobReportController class.
     *
     * @param jobReportService The JobReportService object.
     */
    public JobReportController(JobReportService jobReportService) {
        this.jobReportService = jobReportService;
    }

    /**
     * This method generates a report of job offers.
     *
     * @param startDate The start date of the report.
     * @param endDate   The end date of the report.
     * @return A byte array containing the report.
     */
    @GetMapping(produces = {MediaType.APPLICATION_OCTET_STREAM_VALUE})
    public ResponseEntity<byte[]> generateReport(@PathParam(value = "startDate") @JsonFormat(pattern = PATTERN_DATE_TIME) LocalDate startDate,
                                                 @PathParam(value = "endDate") @JsonFormat(pattern = PATTERN_DATE_TIME) LocalDate endDate) {
        return jobReportService.generateJobsReport(startDate, endDate);
    }

}
