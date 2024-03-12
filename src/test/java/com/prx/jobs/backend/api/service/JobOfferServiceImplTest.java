package com.prx.jobs.backend.api.service;

import com.prx.jobs.backend.api.to.GetJobOfferResponse;
import com.prx.jobs.backend.api.to.JobOfferContentTO;
import com.prx.jobs.backend.api.to.JobOfferResponse;
import com.prx.jobs.backend.api.to.PostJobOfferRequest;
import com.prx.jobs.backend.jpa.entity.*;
import com.prx.jobs.backend.jpa.repository.JobOfferRepository;
import com.prx.jobs.backend.mapper.JobOfferMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@SpringBootTest
class JobOfferServiceImplTest {

    @InjectMocks
    private JobOfferServiceImpl jobOfferService;
    @Mock
    private JobOfferDetailServiceImpl jobOfferDetailService;
    @Mock
    private JobOfferRepository jobOfferRepository;
    @Mock
    private JobOfferMapper jobOfferMapper;

    @Test
    void findPostReturnsOkWhenPostExists() {
        UUID postId = UUID.randomUUID();
        List<Object[][]> postEntities = new ArrayList<>();
        var objects = new Object[10][1];
        objects[0][0] = postId.toString();
        objects[1][0] = "100.00";
        objects[2][0] = "2022-01-01 00:00:00.0";
        objects[3][0] = "2022-01-01 00:00:00.0";
        objects[4][0] = "title";
        objects[5][0] = "description";
        objects[6][0] = "content";
        objects[7][0] = "author";
        objects[8][0] = "category";
        objects[9][0] = "tags";
        postEntities.add(objects);
        when(jobOfferRepository.findJobOfferEntities()).thenReturn(Optional.of(postEntities));

        ResponseEntity<List<JobOfferContentTO>> response = jobOfferService.findJobOfferContent();

        assertTrue(response.getStatusCode().equals(HttpStatus.OK));
        assertTrue(!response.getBody().isEmpty()); // Assuming the mapping function is not yet implemented
    }

    @Test
    void findPostContentReturnsNotFoundWhenPostDoesNotExist() {
        when(jobOfferRepository.findJobOfferEntities()).thenReturn(Optional.empty());

        ResponseEntity<List<JobOfferContentTO>> response = jobOfferService.findJobOfferContent();

        assertTrue(response.getStatusCode().is4xxClientError());
    }

    @Test
    void findPostContentByPostIdReturnsPostContentWhenPostExists() {
        UUID uuid = UUID.randomUUID();
        var companyEntity = new CompanyEntity();
        var positionEntity = new PositionEntity();
        var termEntity = new TermEntity();
        var modeEntity = new ModeEntity();
        var sourceEntity = new SourceEntity();
        positionEntity.setId(UUID.randomUUID());
        positionEntity.setName("position");
        termEntity.setId(UUID.randomUUID());
        termEntity.setName("term");
        modeEntity.setId(UUID.randomUUID());
        modeEntity.setName("mode");
        sourceEntity.setId(UUID.randomUUID());
        sourceEntity.setName("source");

        GetJobOfferResponse getJobOfferResponse = new GetJobOfferResponse(
                uuid,
                "Title",
                "Description",
                "reference",
                companyEntity.getId(),
                companyEntity.getName(),
                positionEntity.getId(),
                positionEntity.getName(),
                termEntity.getId(),
                termEntity.getName(),
                modeEntity.getId(),
                modeEntity.getName(),
                sourceEntity.getId(),
                sourceEntity.getName(),
                new ArrayList<>()
        );
        JobOfferEntity jobOfferEntity = new JobOfferEntity();
        jobOfferEntity.setId(uuid);
        jobOfferEntity.setTitle("Title");
        jobOfferEntity.setDescription("Description");
        jobOfferEntity.setReference("reference");

        when(jobOfferRepository.findById(uuid)).thenReturn(Optional.of(jobOfferEntity));
        when(jobOfferDetailService.findJobOfferDetailTOByJobOfferId(uuid)).thenReturn(Optional.of(new ArrayList<>()));
        when(jobOfferMapper.toTarget(Mockito.any(JobOfferEntity.class))).thenReturn(getJobOfferResponse);

        ResponseEntity<GetJobOfferResponse> response = jobOfferService.findJobOfferContentByJobOfferId(uuid);

        assertEquals(ResponseEntity.ok(getJobOfferResponse), response);
    }

    @Test
    void findPostContentByPostIdReturnsNotFoundWhenPostDoesNotExist() {
        UUID uuid = UUID.randomUUID();
        when(jobOfferRepository.findById(uuid)).thenReturn(Optional.empty());

        ResponseEntity<GetJobOfferResponse> response = jobOfferService.findJobOfferContentByJobOfferId(uuid);

        assertEquals(ResponseEntity.notFound().build(), response);
    }

    @Test
    @DisplayName("Should return CREATED response when creating a job offer")
    void shouldReturnOkResponseWhenCreatingJobOffer() {
        var companyEntity = new CompanyEntity();
        var positionEntity = new PositionEntity();
        var termEntity = new TermEntity();
        var modeEntity = new ModeEntity();
        var sourceEntity = new SourceEntity();
        positionEntity.setId(UUID.randomUUID());
        termEntity.setId(UUID.randomUUID());
        modeEntity.setId(UUID.randomUUID());
        sourceEntity.setId(UUID.randomUUID());
        JobOfferEntity entity = new JobOfferEntity();
        entity.setId(UUID.randomUUID());
        entity.setCompany(companyEntity);
        entity.setPosition(positionEntity);
        entity.setTerm(termEntity);
        entity.setMode(modeEntity);
        entity.setSource(sourceEntity);
        entity.setReference("reference");
        entity.setDescription("description");
        entity.setTitle("title");
        PostJobOfferRequest request = new PostJobOfferRequest("title", "description", "reference",
                UUID.randomUUID(), UUID.randomUUID(), UUID.randomUUID(), UUID.randomUUID(), UUID.randomUUID(), UUID.randomUUID(),
                BigDecimal.valueOf(200000), LocalDateTime.now());
        JobOfferResponse response = new JobOfferResponse(UUID.randomUUID(), LocalDateTime.now(), "Job offer created successfully");

        when(jobOfferRepository.save(Mockito.any(JobOfferEntity.class))).thenReturn(entity);
        when(jobOfferMapper.toPostJobOfferResponse(Mockito.any(JobOfferEntity.class))).thenReturn(response);

        ResponseEntity<JobOfferResponse> result = jobOfferService.createJobOffer(request);

        assertEquals(HttpStatus.CREATED, result.getStatusCode());
        assertEquals(response, result.getBody());
    }

    @Test
    @DisplayName("Should return NOT_ACCEPTABLE response when creating a job offer")
    void shouldReturnOkResponseWhenIdNull() {
        var companyEntity = new CompanyEntity();
        var positionEntity = new PositionEntity();
        var termEntity = new TermEntity();
        var modeEntity = new ModeEntity();
        var sourceEntity = new SourceEntity();
        positionEntity.setId(UUID.randomUUID());
        termEntity.setId(UUID.randomUUID());
        modeEntity.setId(UUID.randomUUID());
        sourceEntity.setId(UUID.randomUUID());
        JobOfferEntity entity = new JobOfferEntity();
        entity.setId(UUID.randomUUID());
        entity.setCompany(companyEntity);
        entity.setPosition(positionEntity);
        entity.setTerm(termEntity);
        entity.setMode(modeEntity);
        entity.setSource(sourceEntity);
        entity.setReference("reference");
        entity.setDescription("description");
        entity.setTitle("title");
        PostJobOfferRequest request = new PostJobOfferRequest("title", "description", "reference",
                UUID.randomUUID(), UUID.randomUUID(), UUID.randomUUID(), UUID.randomUUID(), UUID.randomUUID(), UUID.randomUUID(),
                BigDecimal.valueOf(200000), LocalDateTime.now());
        JobOfferResponse response = new JobOfferResponse(null, LocalDateTime.now(), null);

        when(jobOfferRepository.save(Mockito.any(JobOfferEntity.class))).thenReturn(entity);
        when(jobOfferMapper.toPostJobOfferResponse(Mockito.any(JobOfferEntity.class))).thenReturn(response);

        ResponseEntity<JobOfferResponse> result = jobOfferService.createJobOffer(request);

        assertEquals(HttpStatus.NOT_ACCEPTABLE, result.getStatusCode());
        assertEquals(null, result.getBody());
    }

    @Test
    @DisplayName("Should return NOT_ACCEPTABLE response when creating a job offer fails")
    void shouldReturnNotAcceptableResponseWhenCreatingJobOfferFails() {
        PostJobOfferRequest request = new PostJobOfferRequest("title", "description", "reference",
                UUID.randomUUID(), UUID.randomUUID(), UUID.randomUUID(), UUID.randomUUID(), UUID.randomUUID(), UUID.randomUUID(),
                BigDecimal.valueOf(200000), LocalDateTime.now());
        JobOfferEntity entity = new JobOfferEntity();
        JobOfferResponse response = new JobOfferResponse(UUID.randomUUID(), null, null);

        when(jobOfferRepository.save(entity)).thenReturn(entity);
        when(jobOfferMapper.toPostJobOfferResponse(entity)).thenReturn(response);

        ResponseEntity<JobOfferResponse> result = jobOfferService.createJobOffer(request);

        assertEquals(HttpStatus.NOT_ACCEPTABLE, result.getStatusCode());
    }
}
