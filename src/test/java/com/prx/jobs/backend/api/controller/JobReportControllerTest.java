package com.prx.jobs.backend.api.controller;

import com.prx.jobs.backend.api.mock.MockLoaderBase;
import com.prx.jobs.backend.api.service.JobReportService;
import com.prx.jobs.backend.jpa.repository.JobReportRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class JobReportControllerTest extends MockLoaderBase {

    @MockBean
    private JobReportService jobReportService;

    @Mock
    private JobReportRepository jobReportRepository;

    @Test
    @DisplayName("Should return job report")
    void generateReportReturnsExpectedResult() {
        when(jobReportService.generateJobsReport(any(), any()))
                .thenReturn(ResponseEntity.ok(new byte[0]));

        given().when().get("/v1/job-offers/reports")
                .then().assertThat().statusCode(HttpStatus.OK.value());
    }

}
