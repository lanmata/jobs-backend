package com.prx.jobs.backend.api.controller;

import com.prx.jobs.backend.api.mock.MockLoaderBase;
import com.prx.jobs.backend.api.service.SourceService;
import com.prx.jobs.backend.api.to.SourceListResponse;
import com.prx.jobs.backend.api.to.SourceTO;
import com.prx.jobs.backend.jpa.repository.SourceRepository;
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

class SourceControllerTest extends MockLoaderBase {

    @MockBean
    private SourceService sourceService;

    @Mock
    private SourceRepository sourceRepository;

    private static final String PATH;

    static {
        PATH = "/v1/sources";
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
