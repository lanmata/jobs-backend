package com.prx.jobs.backend.api.controller;

import com.prx.jobs.backend.api.service.ModeServiceImpl;
import com.prx.jobs.backend.api.to.ModeListResponse;
import com.prx.jobs.backend.api.to.ModeTO;
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

import java.util.ArrayList;
import java.util.Collections;
import java.util.UUID;

import static com.prx.jobs.backend.util.JobsConstants.JOBS_PATH;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(value = {SpringExtension.class})
class ModeApiControllerTest {

    static String PATH;

    static {
        PATH = JOBS_PATH + "/modes";
    }

    @MockBean
    private ModeServiceImpl modeService;

    @BeforeEach
    void setUp() {
        RestAssuredMockMvc.standaloneSetup(new ModeApiController(modeService));
    }

    @Test
    void getServiceTest() {
        var apiController = new ModeApiController(modeService);
        assertNotNull(apiController.getService());
    }

    @Test
    @DisplayName("Should return mode list when includeInactive is true")
    void listIncludesInactiveModesWhenRequested() {
        var modeCollection = new ArrayList<ModeTO>();
        modeCollection.add(new ModeTO(UUID.randomUUID(), "description", "Mode Description", true));
        when(modeService.list(true)).thenReturn(ResponseEntity.ok(new ModeListResponse(modeCollection)));

        given().queryParam("includeInactive", true).contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE).when().get(PATH)
                .then().assertThat().statusCode(HttpStatus.OK.value()).expect(MvcResult::getResponse);
    }

    @Test
    @DisplayName("Should return mode list when includeInactive is false")
    void listWithoutInactiveModesWhenRequested() {
        when(modeService.list(false)).thenReturn(ResponseEntity.ok(new ModeListResponse(Collections.emptyList())));

        given().queryParam("includeInactive", false).contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE).when().get(PATH)
                .then().assertThat().statusCode(HttpStatus.OK.value()).expect(MvcResult::getResponse);
    }

}