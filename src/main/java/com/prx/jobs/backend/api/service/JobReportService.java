package com.prx.jobs.backend.api.service;

import org.springframework.http.ResponseEntity;

import java.time.LocalDate;

import static com.prx.jobs.backend.util.JobsConstants.NOT_IMPLEMENTED;

/**
 * This is the JobReportService interface.
 * It provides methods for generating job offer reports.
 */
public interface JobReportService {

    /**
     * This method generates a report of job offers.
     *
     * @param startDate The start date of the report.
     * @param endDate   The end date of the report.
     * @return A byte array containing the report.
     */
    default ResponseEntity<byte[]> generateJobsReport(LocalDate startDate, LocalDate endDate) {
        throw new UnsupportedOperationException(NOT_IMPLEMENTED);
    }
}
