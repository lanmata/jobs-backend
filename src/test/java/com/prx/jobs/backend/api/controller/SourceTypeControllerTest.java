package com.prx.jobs.backend.api.controller;

import com.prx.jobs.backend.api.service.SourceTypeServiceImpl;
import com.prx.jobs.backend.api.to.SourceTypeListResponse;
import com.prx.jobs.backend.api.to.SourceTypeTO;
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

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.mockito.Mockito.when;

@ExtendWith(value = {SpringExtension.class})
class SourceTypeControllerTest {

    private static final String PATH;

    static {
        PATH = "/v1/source-types";
    }

    @MockBean
    private SourceTypeServiceImpl sourceTypeService;

    @BeforeEach
    void setUp() {
        RestAssuredMockMvc.standaloneSetup(new SourceTypeController(sourceTypeService));
    }

    @Test
    @DisplayName("Should return source type list when includeInactive is true")
    void listIncludesInactiveSourceTypesWhenRequested() {
        when(sourceTypeService.list(true)).thenReturn(ResponseEntity.ok(new SourceTypeListResponse(
                Collections.singletonList(new SourceTypeTO(UUID.randomUUID(), "Test", "Test", false)))));

        given().contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE).when().get(PATH + "?includeInactive=true")
                .then().assertThat().statusCode(HttpStatus.OK.value()).expect(MvcResult::getResponse);
    }

    @Test
    @DisplayName("Should return source type list when includeInactive is false")
    void listExcludesInactiveSourceTypesWhenRequested() {
        when(sourceTypeService.list(false)).thenReturn(ResponseEntity.ok(new SourceTypeListResponse(
                Collections.emptyList())));

        given().contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE).when().get(PATH + "?includeInactive=false")
                .then().assertThat().statusCode(HttpStatus.OK.value()).expect(MvcResult::getResponse);
    }

}
