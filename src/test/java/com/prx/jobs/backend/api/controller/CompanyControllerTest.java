package com.prx.jobs.backend.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.prx.jobs.backend.api.mock.MockLoaderBase;
import com.prx.jobs.backend.api.service.CompanyService;
import com.prx.jobs.backend.api.to.CompanyListResponse;
import com.prx.jobs.backend.api.to.CompanyTO;
import com.prx.jobs.backend.jpa.repository.CompanyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.mockito.Mockito.when;

class CompanyControllerTest extends MockLoaderBase {

    @MockBean
    private CompanyService companyService;

    @Mock
    private CompanyRepository companyRepository;

    @Autowired
    private ObjectMapper objectMapper;

    private static final String PATH;

    static {
        PATH = "/v1/companies";
    }

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Should return company list when includeInactive is true")
    void shouldReturnCompanyListWhenIncludeInactiveIsTrue() {
        CompanyTO companyTO = new CompanyTO(UUID.randomUUID(), "name", "description", false);
        CompanyListResponse companyListResponse = new CompanyListResponse(List.of(companyTO));
        when(companyService.list(true)).thenReturn(ResponseEntity.ok(companyListResponse));

        given().contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE).when().get(PATH + "?includeInactive=true")
                .then().assertThat().statusCode(HttpStatus.OK.value()).expect(MvcResult::getResponse);
    }

    @Test
    @DisplayName("Should return company list when includeInactive is false")
    void shouldReturnCompanyListWhenIncludeInactiveIsFalse() {
        CompanyListResponse companyListResponse = new CompanyListResponse(Collections.emptyList());
        when(companyService.list(false)).thenReturn(ResponseEntity.ok(companyListResponse));

        given().contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE).when().get(PATH + "?includeInactive=false")
                .then().assertThat().statusCode(HttpStatus.OK.value()).expect(MvcResult::getResponse);
    }
}
