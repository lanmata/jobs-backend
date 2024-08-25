package com.prx.jobs.backend.api.controller;

import com.prx.jobs.backend.api.service.CompanyServiceImpl;
import com.prx.jobs.backend.api.to.CompanyListResponse;
import com.prx.jobs.backend.api.to.CompanyTO;
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
import java.util.List;
import java.util.UUID;

import static com.prx.jobs.backend.util.JobsConstants.JOBS_PATH;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(value = {SpringExtension.class})
class CompanyApiTest {

    private static final String PATH;

    static {
        PATH = JOBS_PATH + "/companies";
    }

    @MockBean
    CompanyServiceImpl companyService;

    @BeforeEach
    public void setUp() {
        RestAssuredMockMvc.standaloneSetup(new CompanyApiController(companyService));
    }

    @Test
    void getServiceTest() {
        var companyApi = new CompanyApi(){};
        assertNotNull(companyApi.getService());
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
