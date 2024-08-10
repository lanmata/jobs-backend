package com.prx.jobs.backend.api.controller;

import com.prx.jobs.backend.api.service.JobOfferDetailServiceImpl;
import com.prx.jobs.backend.api.to.JobOfferDetailTO;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MvcResult;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.UUID;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.mockito.Mockito.when;

@ExtendWith(value = {SpringExtension.class})
class JobOfferDetailControllerTest {

    private static final String PATH;

    static {
        PATH = "/v1/job-offer-details";
    }

    @MockBean
    JobOfferDetailServiceImpl jobOfferDetailService;

    @BeforeEach
    void setUp() {
        RestAssuredMockMvc.standaloneSetup(new JobOfferDetailController(jobOfferDetailService));
    }

    @Test
    void findJobOfferDetailByJobOfferIdReturnsExpectedResult() {
        UUID id = UUID.randomUUID();
        String description = "Test Description";
        LocalDateTime datetime = LocalDateTime.now();
        BigDecimal mountRate = new BigDecimal("10.0");
        UUID jobOfferId = UUID.randomUUID();
        UUID statusId = UUID.randomUUID();

        when(jobOfferDetailService.findOfferDetailByJobOfferId(jobOfferId))
                .thenReturn(ResponseEntity.ok(Collections.singletonList(new JobOfferDetailTO(id, description, datetime, mountRate, jobOfferId, statusId))));

        given().contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE).when().get(PATH + "?jobOfferId=" + jobOfferId)
                .then().assertThat().statusCode(HttpStatus.OK.value()).expect(MvcResult::getResponse);
    }

    @Test
    void findJobOfferDetailByJobOfferIdReturnsEmptyWhenNoDetailFound() {
        String jobOfferId = UUID.randomUUID().toString();
        when(jobOfferDetailService.findOfferDetailByJobOfferId(UUID.fromString(jobOfferId))).thenReturn(ResponseEntity.ok(Collections.emptyList()));

        given().contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE).when().get(PATH + "?jobOfferId=" + jobOfferId)
                .then().assertThat().statusCode(HttpStatus.OK.value()).expect(MvcResult::getResponse);
    }
}
