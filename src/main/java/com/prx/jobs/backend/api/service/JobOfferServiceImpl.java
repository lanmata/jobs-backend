package com.prx.jobs.backend.api.service;

import com.prx.jobs.backend.api.to.*;
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
    public JobOfferServiceImpl(JobOfferRepository jobOfferRepository, JobOfferDetailService jobOfferDetailService, JobOfferMapper jobOfferMapper) {
        this.jobOfferRepository = jobOfferRepository;
        this.jobOfferDetailService = jobOfferDetailService;
        this.jobOfferMapper = jobOfferMapper;
    }

    private static JobOfferEntity getJobOfferEntity(PostJobOfferRequest postJobOfferRequest) {
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
        return jobOfferEntity;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<List<JobOfferContentTO>> findJobOfferContent() {
        var optionalResult = jobOfferRepository.findJobOfferEntities();
        return optionalResult.map(objects -> ResponseEntity.ok(mapToObjectArrayToJobOfferContentTO(objects.stream().toList()))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<GetJobOfferResponse> findJobOfferContentByJobOfferId(UUID jobOfferId) {
        var optionalResult = jobOfferRepository.findById(jobOfferId);
        if (optionalResult.isPresent()) {
            var getJobOfferResponse = jobOfferMapper.toTarget(optionalResult.get());
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
        final var jobOfferEntity = getJobOfferEntity(postJobOfferRequest);

        var jobOfferResponse = jobOfferMapper.toPostJobOfferResponse(jobOfferRepository.save(jobOfferEntity));
        if (Objects.nonNull(jobOfferResponse) && Objects.nonNull(jobOfferResponse.getId())) {
            var jobOfferDetail = jobOfferDetailService.postJobOfferDetail(jobOfferResponse.getId(), new PostJobOfferDetailRequest(postJobOfferRequest.description(),
                    postJobOfferRequest.dateTime(), postJobOfferRequest.mountRate(), postJobOfferRequest.statusId()));
            jobOfferResponse.setCreatedDate(LocalDateTime.now());
            if (Objects.nonNull(jobOfferDetail) && Objects.nonNull(jobOfferDetail.id())) {
                jobOfferResponse.setMessage("Job offer created");
                jobOfferResponse.setJobOfferDetailId(jobOfferDetail.id());
                return ResponseEntity.status(HttpStatus.CREATED).body(jobOfferResponse);
            }
            jobOfferResponse.setMessage("Job offer without offer detail was created");
            return ResponseEntity.status(HttpStatus.CREATED).body(jobOfferResponse);
        }
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<PutJobOfferResponse> updateJobOffer(UUID uuid, PutJobOfferRequest putJobOfferRequest) {
        var optionalResult = jobOfferRepository.findById(uuid);
        if (optionalResult.isPresent()) {
            var jobOfferEntity = optionalResult.get();
            var postJobOfferDetailRequest = new PostJobOfferDetailRequest(putJobOfferRequest.description(),
                    putJobOfferRequest.createdDateTime(), putJobOfferRequest.mountRate(), putJobOfferRequest.statusId());
            if (Objects.nonNull(putJobOfferRequest.companyId())) {
                var companyEntity = new CompanyEntity();
                companyEntity.setId(putJobOfferRequest.companyId());
                jobOfferEntity.setCompany(companyEntity);
            }
            if (Objects.nonNull(putJobOfferRequest.modeId())) {
                var modeEntity = new ModeEntity();
                jobOfferEntity.setMode(modeEntity);
            }
            if (Objects.nonNull(putJobOfferRequest.termId())) {
                var termEntity = new TermEntity();
                jobOfferEntity.setTerm(termEntity);
            }
            if (Objects.nonNull(putJobOfferRequest.sourceId())) {
                var sourceEntity1 = new SourceEntity();
                jobOfferEntity.setSource(sourceEntity1);
            }
            var putJobOfferResponse = jobOfferMapper.toPutJobOfferResponse(jobOfferRepository.save(jobOfferEntity));
            var postJobOfferDetailResponse = jobOfferDetailService.postJobOfferDetail(jobOfferEntity.getId(), postJobOfferDetailRequest);
            if (Objects.nonNull(putJobOfferResponse.getId()) && Objects.nonNull(postJobOfferDetailResponse)) {
                putJobOfferResponse.setCreatedDate(LocalDateTime.now());
                putJobOfferResponse.setMessage("Job offer updated");
                putJobOfferResponse.setJobOfferDetailId(postJobOfferDetailResponse.id());
                return ResponseEntity.status(HttpStatus.CREATED).body(putJobOfferResponse);
            }
            putJobOfferResponse.setMessage("Job offer not updated");
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(putJobOfferResponse);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    /**
     * Gets the job offer detail by job offer id.
     *
     * @param getJobOfferResponse The GetJobOfferResponse object.
     */
    private void getJobOfferDetailByJobOfferId(GetJobOfferResponse getJobOfferResponse) {
        jobOfferDetailService.findJobOfferDetailTOByJobOfferId(getJobOfferResponse.id()).ifPresent(postDetailTOList -> getJobOfferResponse.postDetailList().addAll(postDetailTOList));
    }

    /**
     * Maps a list of Object[][] to a list of JobOfferContentTO.
     *
     * @param list List of Object[][].
     * @return List of JobOfferContentTO.
     */
    private List<JobOfferContentTO> mapToObjectArrayToJobOfferContentTO(List<Object[][]> list) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S", Locale.ROOT);
        return list.stream().map(objects -> new JobOfferContentTO(UUID.fromString(objects[0][0].toString()), new BigDecimal(objects[1][0].toString()), LocalDateTime.parse(objects[2][0].toString(), dateTimeFormatter), LocalDateTime.parse(objects[3][0].toString(), dateTimeFormatter), objects[4][0].toString(), objects[5][0].toString(), objects[6][0].toString(), objects[7][0].toString(), objects[8][0].toString(), objects[9][0].toString())).collect(Collectors.toCollection(ArrayList::new));
    }
}
