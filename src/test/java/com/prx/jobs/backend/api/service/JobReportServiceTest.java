package com.prx.jobs.backend.api.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.prx.jobs.backend.util.JobsConstants.NOT_IMPLEMENTED;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * This is the JobReportServiceTest class.
 * It provides methods for testing the JobReportService class.
 */
class JobReportServiceTest {

    private final JobReportService jobReportService = new JobReportService() {
    };

    @Test
    @DisplayName("Test generateJobsReport")
    void testGenerateJobsReport() {
        UnsupportedOperationException exception = assertThrows(UnsupportedOperationException.class, () -> jobReportService.generateJobsReport(null, null));
        assertEquals(NOT_IMPLEMENTED, exception.getMessage());
    }

}
