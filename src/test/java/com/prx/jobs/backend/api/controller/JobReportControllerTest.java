package com.prx.jobs.backend.api.controller;

import com.prx.jobs.backend.api.service.JobReportServiceImpl;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static com.prx.jobs.backend.util.JobsConstants.JOBS_PATH;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(value = {SpringExtension.class})
class JobReportControllerTest {

    @MockBean
    private JobReportServiceImpl jobReportService;

    @BeforeEach
    void setUp() {
        RestAssuredMockMvc.standaloneSetup(new JobReportController(jobReportService));
    }

    @Test
    @DisplayName("Should return job report")
    void generateReportReturnsExpectedResult() {
        when(jobReportService.generateJobsReport(any(), any()))
                .thenReturn(ResponseEntity.ok(new byte[0]));

        given().when().get(JOBS_PATH + "/reports")
                .then().assertThat().statusCode(HttpStatus.OK.value());
    }

}
