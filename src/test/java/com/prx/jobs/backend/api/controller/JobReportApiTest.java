package com.prx.jobs.backend.api.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JobReportApiTest {

    JobReportApi jobReportApi = new JobReportApi() {};

    @Test
    @DisplayName("It call getService method to get a new JobReportService instance")
    void getServiceTest() {
        assertNotNull(jobReportApi.getService());
    }

}
