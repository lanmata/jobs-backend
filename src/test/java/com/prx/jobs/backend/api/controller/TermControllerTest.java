package com.prx.jobs.backend.api.controller;

import com.prx.jobs.backend.api.mock.MockLoaderBase;
import com.prx.jobs.backend.api.service.TermService;
import com.prx.jobs.backend.api.to.TermListResponse;
import com.prx.jobs.backend.api.to.TermTO;
import com.prx.jobs.backend.jpa.repository.TermRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Collections;
import java.util.UUID;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.mockito.Mockito.when;

class TermControllerTest extends MockLoaderBase {

    @MockBean
    private TermService termService;

    @Mock
    private TermRepository termRepository;

    private static final String PATH;

    static {
        PATH = "/v1/terms";
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
