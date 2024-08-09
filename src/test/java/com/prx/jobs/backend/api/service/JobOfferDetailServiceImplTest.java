package com.prx.jobs.backend.api.service;

import com.prx.jobs.backend.api.to.JobOfferDetailTO;
import com.prx.jobs.backend.api.to.PostJobOfferDetailRequest;
import com.prx.jobs.backend.api.to.PostJobOfferDetailResponse;
import com.prx.jobs.backend.api.to.SimpleResponse;
import com.prx.jobs.backend.jpa.entity.JobOfferDetailEntity;
import com.prx.jobs.backend.jpa.entity.JobOfferEntity;
import com.prx.jobs.backend.jpa.entity.StatusEntity;
import com.prx.jobs.backend.jpa.repository.JobOfferDetailRepository;
import com.prx.jobs.backend.mapper.JobOfferDetailMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(value = {SpringExtension.class})
class JobOfferDetailServiceImplTest {

    @Mock
    private JobOfferDetailRepository jobOfferDetailRepository;

    @Mock
    private JobOfferDetailMapper jobOfferDetailMapper;

    @InjectMocks
    private JobOfferDetailServiceImpl jobOfferDetailService;

    @Test
    void shouldReturnPostDetailsWhenPostExists() {
        UUID postId = UUID.randomUUID();
        var postDetailEntity = new JobOfferDetailEntity();
        var postEntity = new JobOfferEntity();
        var statusEntity = new StatusEntity();
        statusEntity.setId(UUID.randomUUID());
        postEntity.setId(postId);
        postDetailEntity.setOfferEntity(postEntity);
        postDetailEntity.setDescription("content");
        postDetailEntity.setDatetime(LocalDateTime.now());
        postDetailEntity.setMountRate(BigDecimal.ONE);
        postDetailEntity.setStatus(statusEntity);
        JobOfferDetailTO jobOfferDetailTO = new JobOfferDetailTO(UUID.randomUUID(), "content",
                LocalDateTime.now(), BigDecimal.ONE, postId, UUID.randomUUID());
        when(jobOfferDetailRepository.findJobOfferDetailEntitiesByPostId(postId)).thenReturn(Optional.of(Collections.singletonList(postDetailEntity)));
        when(jobOfferDetailMapper.toTarget(Collections.singletonList(postDetailEntity))).thenReturn(Collections.singletonList(jobOfferDetailTO));

        ResponseEntity<List<JobOfferDetailTO>> response = jobOfferDetailService.findOfferDetailByJobOfferId(postId);

        assertEquals(ResponseEntity.ok(Collections.singletonList(jobOfferDetailTO)), response);
    }

    @Test
    void shouldReturnNotFoundWhenPostDoesNotExist() {
        UUID postId = UUID.randomUUID();
        when(jobOfferDetailRepository.findJobOfferDetailEntitiesByPostId(postId)).thenReturn(Optional.empty());

        ResponseEntity<List<JobOfferDetailTO>> response = jobOfferDetailService.findOfferDetailByJobOfferId(postId);

        assertTrue(response.getStatusCode().is4xxClientError());
    }

    @Test
    @DisplayName("Should return job offer details when job offer id is valid")
    void shouldReturnJobOfferDetailsWhenJobOfferIdIsValid() {
        UUID jobOfferId = UUID.randomUUID();
        JobOfferDetailEntity entity = new JobOfferDetailEntity();
        UUID id = UUID.randomUUID();
        String description = "Test Description";
        LocalDateTime datetime = LocalDateTime.now();
        BigDecimal mountRate = new BigDecimal("10.0");
        UUID postId = UUID.randomUUID();
        UUID statusId = UUID.randomUUID();

        JobOfferDetailTO jobOfferDetailTO = new JobOfferDetailTO(id, description, datetime, mountRate, postId, statusId);
        List<JobOfferDetailEntity> entities = Collections.singletonList(entity);
        List<JobOfferDetailTO> tos = Collections.singletonList(jobOfferDetailTO);

        when(jobOfferDetailRepository.findJobOfferDetailEntitiesByPostId(jobOfferId)).thenReturn(Optional.of(entities));
        when(jobOfferDetailMapper.toTarget(entities)).thenReturn(tos);

        Optional<List<JobOfferDetailTO>> result = jobOfferDetailService.findJobOfferDetailTOByJobOfferId(jobOfferId);

        assertTrue(result.isPresent());
        assertEquals(tos, result.get());
    }

    @Test
    @DisplayName("Should return empty when job offer id is not valid")
    void shouldReturnEmptyWhenJobOfferIdIsNotValid() {
        UUID jobOfferId = UUID.randomUUID();

        when(jobOfferDetailRepository.findJobOfferDetailEntitiesByPostId(jobOfferId)).thenReturn(Optional.empty());

        Optional<List<JobOfferDetailTO>> result = jobOfferDetailService.findJobOfferDetailTOByJobOfferId(jobOfferId);

        assertTrue(result.isEmpty());
    }

    @Test
    void shouldPostJobOfferDetailSuccessfully() {
        UUID jobOfferId = UUID.randomUUID();
        var request = new PostJobOfferDetailRequest("Job description", LocalDateTime.now(), new BigDecimal("100.00"), jobOfferId);
        JobOfferEntity jobOfferEntity = new JobOfferEntity();
        jobOfferEntity.setId(jobOfferId);
        JobOfferDetailEntity jobOfferDetailEntity = new JobOfferDetailEntity();
        jobOfferDetailEntity.setOfferEntity(jobOfferEntity);
        jobOfferDetailEntity.setId(UUID.randomUUID());

        when(jobOfferDetailMapper.toSource(request)).thenReturn(jobOfferDetailEntity);
        when(jobOfferDetailRepository.save(jobOfferDetailEntity)).thenReturn(jobOfferDetailEntity);

        PostJobOfferDetailResponse response = jobOfferDetailService.postJobOfferDetail(jobOfferId, request);

        assertNotNull(response);
    }

    @Test
    void shouldReturnNotAcceptableWhenPostJobOfferDetailFails() {
        UUID jobOfferId = UUID.randomUUID();
        PostJobOfferDetailRequest request = new PostJobOfferDetailRequest("Job description", LocalDateTime.now(), new BigDecimal("100.00"), jobOfferId);
        JobOfferEntity jobOfferEntity = new JobOfferEntity();
        jobOfferEntity.setId(jobOfferId);
        JobOfferDetailEntity jobOfferDetailEntity = new JobOfferDetailEntity();
        jobOfferDetailEntity.setOfferEntity(jobOfferEntity);

        when(jobOfferDetailMapper.toSource(request)).thenReturn(jobOfferDetailEntity);
        when(jobOfferDetailRepository.save(jobOfferDetailEntity)).thenReturn(jobOfferDetailEntity);

        PostJobOfferDetailResponse response = jobOfferDetailService.postJobOfferDetail(jobOfferId, request);

        assertNotNull(response);
    }

    @Test
    @DisplayName("Should return NOT_FOUND status when job offer detail does not exist")
    void shouldReturnNotFoundWhenJobOfferDetailDoesNotExist() {
        UUID jobOfferDetailId = UUID.randomUUID();
        when(jobOfferDetailRepository.findById(jobOfferDetailId)).thenReturn(Optional.empty());

        ResponseEntity<SimpleResponse> response = jobOfferDetailService.deleteOfferDetail(jobOfferDetailId);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        verify(jobOfferDetailRepository, times(1)).findById(jobOfferDetailId);
        verify(jobOfferDetailRepository, times(0)).deleteById(jobOfferDetailId);
    }

    @Test
    @DisplayName("Should return OK status and delete job offer detail when it exists")
    void shouldReturnOkAndDeleteJobOfferDetailWhenItExists() {
        UUID jobOfferDetailId = UUID.randomUUID();
        when(jobOfferDetailRepository.findById(jobOfferDetailId)).thenReturn(Optional.of(new JobOfferDetailEntity()));

        ResponseEntity<SimpleResponse> response = jobOfferDetailService.deleteOfferDetail(jobOfferDetailId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(jobOfferDetailRepository, times(1)).findById(jobOfferDetailId);
        verify(jobOfferDetailRepository, times(1)).deleteById(jobOfferDetailId);
    }
}
