package com.prx.jobs.backend.api.controller;

import com.prx.jobs.backend.api.service.JobOfferDetailServiceImpl;
import com.prx.jobs.backend.api.service.JobOfferServiceImpl;
import com.prx.jobs.backend.api.to.*;
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

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.UUID;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(value = {SpringExtension.class})
class JobOfferControllerTest {

    private static final String PATH;

    static {
        PATH = "/v1/job-offers";
    }

    @MockBean
    private JobOfferServiceImpl jobOfferService;
    @MockBean
    private JobOfferDetailServiceImpl jobOfferDetailService;

    @BeforeEach
    public void setUp() {
        RestAssuredMockMvc.standaloneSetup(new JobOfferController(jobOfferService));
    }

    @Test
    void findJobOfferContentReturnsExpectedResult() {
        UUID id = UUID.randomUUID();
        BigDecimal mount = new BigDecimal("1000.00");
        LocalDateTime createdDate = LocalDateTime.now();
        LocalDateTime lastModifiedDate = LocalDateTime.now();
        String status = "active";
        String company = "Company";
        String position = "Position";
        String term = "Term";
        String mode = "Mode";
        String source = "Source";

        JobOfferContentTO jobOfferContentTO = new JobOfferContentTO(id, mount, createdDate,
                lastModifiedDate, status, company, position, term, mode, source);
        when(jobOfferService.findJobOfferContent()).thenReturn(ResponseEntity.ok(Collections.singletonList(jobOfferContentTO)));

        given().contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE).when().get(PATH + "/collection")
                .then().assertThat().statusCode(HttpStatus.OK.value()).expect(MvcResult::getResponse);

    }

    @Test
    void getJobOfferReturnsExpectedResult() {
        UUID id = UUID.randomUUID();
        GetJobOfferResponse getJobOfferResponse = new GetJobOfferResponse(id, "title", "description",
                "reference", UUID.randomUUID(), "company",
                UUID.randomUUID(), "position",
                UUID.randomUUID(), "term", UUID.randomUUID(), "mode",
                UUID.randomUUID(), "source", null);
        String jobOfferId = UUID.randomUUID().toString();
        when(jobOfferService.findJobOfferContentByJobOfferId(UUID.fromString(jobOfferId))).thenReturn(ResponseEntity.ok(getJobOfferResponse));

        given().contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE).when().get(PATH + "?jobOfferId=" + jobOfferId)
                .then().assertThat().statusCode(HttpStatus.OK.value()).expect(MvcResult::getResponse);
    }

    @Test
    void postJobOfferReturnsExpectedResult() {
        // Given
        String title = "Software Engineer";
        String description = "Develop and maintain software applications";
        String reference = "REF123";
        UUID companyId = UUID.randomUUID();
        UUID positionId = UUID.randomUUID();
        UUID termId = UUID.randomUUID();
        UUID modeId = UUID.randomUUID();
        UUID sourceId = UUID.randomUUID();
        UUID statusId = UUID.randomUUID();
        BigDecimal mountRate = new BigDecimal("1000.00");
        LocalDateTime dateTime = LocalDateTime.now();

        // When
        PostJobOfferRequest postJobOfferRequest = new PostJobOfferRequest(title, description, reference, companyId, positionId,
                termId, modeId, sourceId, statusId, mountRate, dateTime);
        PostJobOfferDetailRequest postJobOfferDetailRequest = new PostJobOfferDetailRequest(description, dateTime, mountRate, statusId);
        PostJobOfferDetailResponse postJobOfferDetailResponse = new PostJobOfferDetailResponse(UUID.randomUUID(), LocalDateTime.now(), "Test message");

        UUID id = UUID.randomUUID();
        LocalDateTime now = LocalDateTime.now();
        String message = "Test message";

        PostJobOfferResponse postJobOfferResponse = new PostJobOfferResponse();
        postJobOfferResponse.setId(id);
        postJobOfferResponse.setCreatedDate(now);
        postJobOfferResponse.setMessage(message);
        postJobOfferResponse.setJobOfferDetailId(UUID.randomUUID());
        when(jobOfferService.createJobOffer(postJobOfferRequest)).thenReturn(ResponseEntity.ok(postJobOfferResponse));
        when(jobOfferDetailService.postJobOfferDetail(postJobOfferResponse.getId(), postJobOfferDetailRequest)).thenReturn(postJobOfferDetailResponse);

        given().contentType(MediaType.APPLICATION_JSON_VALUE).body(postJobOfferRequest)
                .accept(MediaType.APPLICATION_JSON_VALUE).when().post(PATH)
                .then().assertThat().statusCode(HttpStatus.OK.value()).expect(MvcResult::getResponse);

    }

    @Test
    void putJobOfferReturnsExpectedResult() {
        PutJobOfferRequest putJobOfferRequest = new PutJobOfferRequest(UUID.randomUUID(), UUID.randomUUID(), UUID.randomUUID(),
                UUID.randomUUID(), UUID.randomUUID(), BigDecimal.TEN, "description", LocalDateTime.now());
        PutJobOfferResponse putJobOfferResponse = new PutJobOfferResponse();
        String jobOfferId = UUID.randomUUID().toString();
        when(jobOfferService.updateJobOffer(UUID.fromString(jobOfferId), putJobOfferRequest)).thenReturn(ResponseEntity.ok(putJobOfferResponse));

        given().contentType(MediaType.APPLICATION_JSON_VALUE).body(putJobOfferRequest)
                .accept(MediaType.APPLICATION_JSON_VALUE).when().put(PATH + "/" + jobOfferId + "/detail")
                .then().assertThat().statusCode(HttpStatus.OK.value()).expect(MvcResult::getResponse);
    }

    @Test
    @DisplayName("Should create job offer with details successfully")
    void shouldCreateJobOfferWithDetailsSuccessfully() {
        // Given
        String title = "Software Engineer";
        String description = "Develop and maintain software applications";
        String reference = "REF123";
        UUID companyId = UUID.randomUUID();
        UUID positionId = UUID.randomUUID();
        UUID termId = UUID.randomUUID();
        UUID modeId = UUID.randomUUID();
        UUID sourceId = UUID.randomUUID();
        UUID statusId = UUID.randomUUID();
        BigDecimal mountRate = new BigDecimal("1000.00");
        LocalDateTime dateTime = LocalDateTime.now();

        // When
        PostJobOfferRequest postJobOfferRequest = new PostJobOfferRequest(title, description, reference, companyId, positionId,
                termId, modeId, sourceId, statusId, mountRate, dateTime);
        PostJobOfferResponse postJobOfferResponse = new PostJobOfferResponse();
        postJobOfferResponse.setId(UUID.randomUUID());
        postJobOfferResponse.setMessage("Job offer created");
        PostJobOfferDetailResponse postJobOfferDetailResponse = new PostJobOfferDetailResponse(UUID.randomUUID(), LocalDateTime.now(), "Test message");

        when(jobOfferDetailService.postJobOfferDetail(any(), any())).thenReturn(postJobOfferDetailResponse);
        when(jobOfferService.createJobOffer(postJobOfferRequest)).thenReturn(ResponseEntity.ok(postJobOfferResponse));

        given().contentType(MediaType.APPLICATION_JSON_VALUE).body(postJobOfferRequest)
                .accept(MediaType.APPLICATION_JSON_VALUE).when().post(PATH)
                .then().assertThat().statusCode(HttpStatus.OK.value()).expect(MvcResult::getResponse);
    }

    @Test
    @DisplayName("Should create job offer without details successfully")
    void shouldCreateJobOfferWithoutDetailsSuccessfully() {
        PostJobOfferRequest request = new PostJobOfferRequest("Software Engineer", "Develop and maintain software applications",
                "REF123", UUID.randomUUID(), UUID.randomUUID(), UUID.randomUUID(), UUID.randomUUID(),
                UUID.randomUUID(), UUID.randomUUID(), new BigDecimal("1000.00"), LocalDateTime.now());
        PostJobOfferResponse response = new PostJobOfferResponse();
        response.setId(UUID.randomUUID());
        response.setMessage("Job offer without offer detail was created");

        when(jobOfferService.createJobOffer(request)).thenReturn(ResponseEntity.ok(response));
        when(jobOfferDetailService.postJobOfferDetail(any(), any())).thenReturn(null);

        ResponseEntity<PostJobOfferResponse> result = jobOfferService.createJobOffer(request);
        given().contentType(MediaType.APPLICATION_JSON_VALUE).body(request)
                .accept(MediaType.APPLICATION_JSON_VALUE).when().post(PATH)
                .then().assertThat().statusCode(HttpStatus.OK.value()).expect(MvcResult::getResponse);
    }

}
