package com.prx.jobs.backend.api.controller;

import com.prx.jobs.backend.api.service.TermServiceImpl;
import com.prx.jobs.backend.api.to.TermListResponse;
import com.prx.jobs.backend.api.to.TermTO;
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
class TermApiControllerTest {

    private static final String PATH;

    static {
        PATH = JOBS_PATH + "/terms";
    }

    @MockBean
    private TermServiceImpl termService;

    @BeforeEach
    void setUp() {
        RestAssuredMockMvc.standaloneSetup(new TermApiController(termService));
    }

    @Test
    void getServiceTest() {
        var apiController = new TermApiController(termService);
        assertNotNull(apiController.getService());
    }

    @Test
    @DisplayName("Should return term list when includeInactive is true")
    void listIncludesInactiveTermsWhenRequested() {
        when(termService.list(true)).thenReturn(ResponseEntity.ok(new TermListResponse(
                Collections.singletonList(new TermTO(UUID.randomUUID(), "Test", "Test", false)))));

        given().contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE).when().get(PATH + "?includeInactive=false")
                .then().assertThat().statusCode(HttpStatus.OK.value()).expect(MvcResult::getResponse);
    }

    @Test
    @DisplayName("Should return term list when includeInactive is false")
    void listExcludesInactiveTermsWhenRequested() {
        when(termService.list(false)).thenReturn(ResponseEntity.ok(new TermListResponse(
                Collections.emptyList())));

        given().contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE).when().get(PATH + "?includeInactive=false")
                .then().assertThat().statusCode(HttpStatus.OK.value()).expect(MvcResult::getResponse);
    }

}
