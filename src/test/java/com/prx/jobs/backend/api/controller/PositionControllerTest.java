package com.prx.jobs.backend.api.controller;

import com.prx.jobs.backend.api.mock.MockLoaderBase;
import com.prx.jobs.backend.api.service.PositionService;
import com.prx.jobs.backend.api.to.PositionListResponse;
import com.prx.jobs.backend.api.to.PositionTO;
import com.prx.jobs.backend.jpa.repository.PositionRepository;
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

class PositionControllerTest extends MockLoaderBase {

    @MockBean
    private PositionService positionService;

    @Mock
    private PositionRepository positionRepository;

    private static final String PATH;

    static {
        PATH = "/v1/positions";
    }

    @Test
    @DisplayName("Should return position list when includeInactive is true")
    void listIncludesInactivePositionsWhenRequested() {
        when(positionService.list(true)).thenReturn(ResponseEntity.ok(new PositionListResponse(
                Collections.singletonList(new PositionTO(UUID.randomUUID(), "Test", "Test", false)))));
        given().contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE).when().get(PATH + "?includeInactive=true")
                .then().assertThat().statusCode(HttpStatus.OK.value()).expect(MvcResult::getResponse);
    }

    @Test
    @DisplayName("Should return position list when includeInactive is false")
    void listExcludesInactivePositionsWhenRequested() {
        when(positionService.list(false)).thenReturn(ResponseEntity.ok(new PositionListResponse(
                Collections.singletonList(new PositionTO(UUID.randomUUID(), "Test", "Test", true)))));
        given().contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE).when().get(PATH + "?includeInactive=false")
                .then().assertThat().statusCode(HttpStatus.OK.value()).expect(MvcResult::getResponse);
    }

}
