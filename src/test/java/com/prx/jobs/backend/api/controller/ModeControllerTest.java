package com.prx.jobs.backend.api.controller;

import com.prx.jobs.backend.api.mock.MockLoaderBase;
import com.prx.jobs.backend.api.service.ModeService;
import com.prx.jobs.backend.api.to.ModeListResponse;
import com.prx.jobs.backend.api.to.ModeTO;
import com.prx.jobs.backend.jpa.repository.ModeRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;
import java.util.Collections;
import java.util.UUID;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.mockito.Mockito.when;

class ModeControllerTest extends MockLoaderBase {

    @MockBean
    private ModeService modeService;

    @Mock
    private ModeRepository modeRepository;

    private static final String PATH;

    static {
        PATH = "/v1/modes";
    }

    @Test
    @DisplayName("Should return mode list when includeInactive is true")
    void listIncludesInactiveModesWhenRequested() {
        var modeCollection = new ArrayList<ModeTO>();
        modeCollection.add(new ModeTO(UUID.randomUUID(), "description", "Mode Description", true));
        when(modeService.list(true)).thenReturn(ResponseEntity.ok(new ModeListResponse(modeCollection)));

        given().contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE).when().get(PATH + "?includeInactive=true")
                .then().assertThat().statusCode(HttpStatus.OK.value()).expect(MvcResult::getResponse);
    }

    @Test
    @DisplayName("Should return mode list when includeInactive is false")
    void listWithoutInactiveModesWhenRequested() {
        when(modeService.list(false)).thenReturn(ResponseEntity.ok(new ModeListResponse(Collections.emptyList())));

        given().contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE).when().get(PATH + "?includeInactive=false")
                .then().assertThat().statusCode(HttpStatus.OK.value()).expect(MvcResult::getResponse);
    }

}