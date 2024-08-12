package com.prx.jobs.backend.api.controller;

import com.prx.jobs.backend.api.service.SourceServiceImpl;
import com.prx.jobs.backend.api.to.SourceListResponse;
import com.prx.jobs.backend.api.to.SourceTO;
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
import static org.mockito.Mockito.when;

@ExtendWith(value = {SpringExtension.class})
class SourceControllerTest {

    private static final String PATH;

    static {
        PATH = JOBS_PATH + "/sources";
    }

    @MockBean
    private SourceServiceImpl sourceService;

    @BeforeEach
    void setUp() {
        RestAssuredMockMvc.standaloneSetup(new SourceController(sourceService));
    }

    @Test
    @DisplayName("Should return source list when includeInactive is true")
    void listIncludesInactiveSourcesWhenRequested() {
        when(sourceService.list(true)).thenReturn(ResponseEntity.ok(new SourceListResponse(
                Collections.singletonList(new SourceTO(UUID.randomUUID(), "Test", "Test", false, UUID.randomUUID())))));
        given().contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE).when().get(PATH + "?includeInactive=true")
                .then().assertThat().statusCode(HttpStatus.OK.value()).expect(MvcResult::getResponse);
    }

    @Test
    @DisplayName("Should return source list when includeInactive is false")
    void listExcludesInactiveSourcesWhenRequested() {
        when(sourceService.list(false)).thenReturn(ResponseEntity.ok(new SourceListResponse(
                Collections.singletonList(new SourceTO(UUID.randomUUID(), "Test", "Test", true, UUID.randomUUID())))));
        given().contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE).when().get(PATH + "?includeInactive=false")
                .then().assertThat().statusCode(HttpStatus.OK.value()).expect(MvcResult::getResponse);
    }

}
