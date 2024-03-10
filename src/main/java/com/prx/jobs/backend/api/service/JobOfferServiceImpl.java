package com.prx.jobs.backend.api.service;

import com.prx.jobs.backend.api.to.GetJobOfferResponse;
import com.prx.jobs.backend.api.to.JobOfferContentTO;
import com.prx.jobs.backend.api.to.PostJobOfferRequest;
import com.prx.jobs.backend.api.to.PostJobOfferResponse;
import com.prx.jobs.backend.jpa.entity.*;
import com.prx.jobs.backend.jpa.repository.JobOfferRepository;
import com.prx.jobs.backend.mapper.JobOfferMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

/**
 * The JobOfferService implementation.
 */
@Service
public class JobOfferServiceImpl implements JobOfferService {

    /**
     * The JobOfferDetailService object.
     */
    private final JobOfferDetailService jobOfferDetailService;
    /**
     * The JobOfferRepository object.
     */
    private final JobOfferRepository jobOfferRepository;
    /**
     * The JobOfferMapper object.
     */
    private final JobOfferMapper jobOfferMapper;

    /**
     * Constructor
     *
     * @param jobOfferRepository    The JobOfferRepository object.
     * @param jobOfferDetailService The JobOfferDetailService object.
     * @param jobOfferMapper        The JobOfferMapper object.
     */
    public JobOfferServiceImpl(JobOfferRepository jobOfferRepository, JobOfferDetailService jobOfferDetailService,
                               JobOfferMapper jobOfferMapper) {
        this.jobOfferRepository = jobOfferRepository;
        this.jobOfferDetailService = jobOfferDetailService;
        this.jobOfferMapper = jobOfferMapper;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<List<JobOfferContentTO>> findJobOfferContent() {
        var optionalResult = jobOfferRepository.findJobOfferEntities();
        return optionalResult.map(objects -> ResponseEntity.ok(mapToObjectArrayToJobOfferContentTO(objects.stream().toList())))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<GetJobOfferResponse> findJobOfferContentByJobOfferId(UUID jobOfferId) {
        var optionalResult = jobOfferRepository.findById(jobOfferId);
        GetJobOfferResponse getJobOfferResponse = null;
        if (optionalResult.isPresent()) {
            getJobOfferResponse = jobOfferMapper.toTarget(optionalResult.get());
            getJobOfferDetailByJobOfferId(getJobOfferResponse);
            return ResponseEntity.ok(getJobOfferResponse);
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<PostJobOfferResponse> createJobOffer(PostJobOfferRequest postJobOfferRequest) {
        var jobOfferEntity = new JobOfferEntity();
        var companyEntity = new CompanyEntity();
        var modeEntity = new ModeEntity();
        var termEntity = new TermEntity();
        var sourceEntity = new SourceEntity();
        var positionEntity = new PositionEntity();
        companyEntity.setId(postJobOfferRequest.companyId());
        modeEntity.setId(postJobOfferRequest.modeId());
        termEntity.setId(postJobOfferRequest.termId());
        sourceEntity.setId(postJobOfferRequest.sourceId());
        positionEntity.setId(postJobOfferRequest.positionId());
        jobOfferEntity.setTitle(postJobOfferRequest.title());
        jobOfferEntity.setDescription(postJobOfferRequest.description());
        jobOfferEntity.setReference(postJobOfferRequest.reference());
        jobOfferEntity.setCompany(companyEntity);
        jobOfferEntity.setPosition(positionEntity);
        jobOfferEntity.setMode(modeEntity);
        jobOfferEntity.setTerm(termEntity);
        jobOfferEntity.setSource(sourceEntity);

        var postJobOfferResponse = jobOfferMapper.toPostJobOfferResponse(jobOfferRepository.save(jobOfferEntity));
        if (Objects.nonNull(postJobOfferResponse) && Objects.nonNull(postJobOfferResponse.id())) {
            return ResponseEntity.status(HttpStatus.CREATED).body(postJobOfferResponse);
        }
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
    }

    /**
     * Gets the job offer detail by job offer id.
     *
     * @param getJobOfferResponse The GetJobOfferResponse object.
     */
    private void getJobOfferDetailByJobOfferId(GetJobOfferResponse getJobOfferResponse) {
        jobOfferDetailService.findJobOfferDetailTOByJobOfferId(getJobOfferResponse.id())
                .ifPresent(postDetailTOList -> getJobOfferResponse.postDetailList().addAll(postDetailTOList));
    }

    /**
     * Maps a list of Object[][] to a list of JobOfferContentTO.
     *
     * @param list List of Object[][].
     * @return List of JobOfferContentTO.
     */
    private List<JobOfferContentTO> mapToObjectArrayToJobOfferContentTO(List<Object[][]> list) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter
                .ofPattern("yyyy-MM-dd HH:mm:ss.S", Locale.ROOT);
        return list.stream().map(objects -> new JobOfferContentTO(
                UUID.fromString(objects[0][0].toString()),
                new BigDecimal(objects[1][0].toString()),
                LocalDateTime.parse(objects[2][0].toString(), dateTimeFormatter),
                LocalDateTime.parse(objects[3][0].toString(), dateTimeFormatter),
                objects[4][0].toString(),
                objects[5][0].toString(),
                objects[6][0].toString(),
                objects[7][0].toString(),
                objects[8][0].toString(),
                objects[9][0].toString())).collect(Collectors.toCollection(ArrayList::new));
    }
}
