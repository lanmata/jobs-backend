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

import java.util.Map;

import static com.prx.jobs.backend.util.JobsConstants.JOBS_PATH;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(value = {SpringExtension.class})
class JobReportApiControllerTest {

    static String PATH;

    static {
        PATH = JOBS_PATH + "/reports";
    }

    @MockBean
    private JobReportServiceImpl jobReportService;

    @BeforeEach
    void setUp() {
        RestAssuredMockMvc.standaloneSetup(new JobReportApiController(jobReportService));
    }

    @Test
    void getServiceTest() {
        var apiController = new JobReportApiController(jobReportService);
        assertNotNull(apiController.getService());
    }

    @Test
    @DisplayName("Should return job report")
    void generateReportReturnsExpectedResult() {
        Map<String, Object> params = Map.of("startDate", "2024-01-01", "endDate", "2024-02-02");
        when(jobReportService.generateJobsReport(any(), any()))
                .thenReturn(ResponseEntity.ok(new byte[0]));

        given().queryParams(params).when().get(PATH).then().assertThat()
                .statusCode(HttpStatus.OK.value());
    }

}
