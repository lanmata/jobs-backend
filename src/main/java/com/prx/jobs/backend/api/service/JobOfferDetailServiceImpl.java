package com.prx.jobs.backend.api.service;

import com.prx.jobs.backend.api.to.JobOfferDetailTO;
import com.prx.jobs.backend.api.to.PostJobOfferDetailRequest;
import com.prx.jobs.backend.api.to.PostJobOfferDetailResponse;
import com.prx.jobs.backend.jpa.entity.JobOfferEntity;
import com.prx.jobs.backend.jpa.repository.JobOfferDetailRepository;
import com.prx.jobs.backend.mapper.JobOfferDetailMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
public class JobOfferDetailServiceImpl implements JobOfferDetailService {

    /**
     * The PostDetailRepository object.
     */
    private final JobOfferDetailRepository jobOfferDetailRepository;

    /**
     * The JobOfferDetailMapper object.
     */
    private final JobOfferDetailMapper jobOfferDetailMapper;

    /**
     * Constructor
     *
     * @param jobOfferDetailRepository The JobOfferDetailRepository object.
     * @param jobOfferDetailMapper     The JobOfferDetailMapper object.
     */
    public JobOfferDetailServiceImpl(JobOfferDetailRepository jobOfferDetailRepository, JobOfferDetailMapper jobOfferDetailMapper) {
        this.jobOfferDetailRepository = jobOfferDetailRepository;
        this.jobOfferDetailMapper = jobOfferDetailMapper;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<List<JobOfferDetailTO>> findOfferDetailByJobOfferId(UUID jobOfferId) {
        var optionalResult = jobOfferDetailRepository.findJobOfferDetailEntitiesByPostId(jobOfferId);
        return optionalResult.map(jobOfferDetailMapper::toTarget).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<List<JobOfferDetailTO>> findJobOfferDetailTOByJobOfferId(UUID jobOfferId) {
        return jobOfferDetailRepository.findJobOfferDetailEntitiesByPostId(jobOfferId).map(jobOfferDetailMapper::toTarget);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PostJobOfferDetailResponse postJobOfferDetail(UUID jobOfferId, PostJobOfferDetailRequest postJobOfferDetailRequest) {
        var jobOfferEntity = new JobOfferEntity();
        var jobOfferDetailEntity = jobOfferDetailMapper.toSource(postJobOfferDetailRequest);
        jobOfferEntity.setId(jobOfferId);
        jobOfferDetailEntity.setOfferEntity(jobOfferEntity);
        var savedJobOfferDetailEntity = jobOfferDetailRepository.save(jobOfferDetailEntity);
        if (Objects.nonNull(savedJobOfferDetailEntity.getId())) {
            return new PostJobOfferDetailResponse(savedJobOfferDetailEntity.getId(), LocalDateTime.now(), null);
        }
        return new PostJobOfferDetailResponse(null, LocalDateTime.now(), "Job offer detail not created");
    }

}
