package com.prx.jobs.backend.api.controller;

import com.prx.jobs.backend.api.service.StatusServiceImpl;
import com.prx.jobs.backend.api.to.StatusListResponse;
import com.prx.jobs.backend.api.to.StatusTO;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Collections;
import java.util.UUID;

import static com.prx.jobs.backend.util.JobsConstants.JOBS_PATH;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(value = {SpringExtension.class})
class StatusApiControllerTest {

    private static final String PATH;

    static {
        PATH = JOBS_PATH + "/status";
    }

    @MockBean
    private StatusServiceImpl statusService;

    @BeforeEach
    void setUp() {
        RestAssuredMockMvc.standaloneSetup(new StatusApiController(statusService));
    }

    @Test
    void getServiceTest() {
        var apiController = new StatusApiController(statusService);
        assertNotNull(apiController.getService());
    }

    @Test
    @DisplayName("Should return status list when includeInactive is true")
    void listIncludesInactiveStatusesWhenRequested() {
        when(statusService.list(true)).thenReturn(ResponseEntity.ok(new StatusListResponse(
                Collections.singletonList(new StatusTO(UUID.randomUUID(), "Test", "Test", false)))));

        given().contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE).when().get(PATH + "?includeInactive=true")
                .then().assertThat().statusCode(HttpStatus.OK.value()).expect(MvcResult::getResponse);
    }

    @Test
    @DisplayName("Should return status list when includeInactive is false")
    void listExcludesInactiveStatusesWhenRequested() {
        when(statusService.list(false)).thenReturn(ResponseEntity.ok(new StatusListResponse(
                Collections.singletonList(new StatusTO(UUID.randomUUID(), "Test", "Test", true)))));

        given().contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE).when().get(PATH + "?includeInactive=false")
                .then().assertThat().statusCode(HttpStatus.OK.value()).expect(MvcResult::getResponse);
    }

}
