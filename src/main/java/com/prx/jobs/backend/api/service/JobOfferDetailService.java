package com.prx.jobs.backend.api.service;

import com.prx.jobs.backend.api.to.JobOfferDetailTO;
import com.prx.jobs.backend.api.to.PostJobOfferDetailRequest;
import com.prx.jobs.backend.api.to.PostJobOfferDetailResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static com.prx.jobs.backend.util.JobsConstants.NOT_IMPLEMENTED;

/**
 * This is the JobOfferDetailService interface.
 * It provides methods for managing job offer records.
 */
public interface JobOfferDetailService {

    /**
     * Finds job offer content by job offer id.
     *
     * @param jobOfferId The job offer id to search for.
     * @return ResponseEntity<List < JobOfferDetailTO>>.
     */
    default ResponseEntity<List<JobOfferDetailTO>> findOfferDetailByJobOfferId(UUID jobOfferId) {
        throw new UnsupportedOperationException(NOT_IMPLEMENTED);
    }

    /**
     * Finds job offer content by job offer id.
     *
     * @param jobOfferId The job offer id to search for.
     * @return Optional<List < JobOfferDetailTO>> The list of job offer details.
     */
    default Optional<List<JobOfferDetailTO>> findJobOfferDetailTOByJobOfferId(UUID jobOfferId) {
        throw new UnsupportedOperationException(NOT_IMPLEMENTED);
    }

    /**
     * Posts job offer detail.
     *
     * @param jobOfferId                The job offer id.
     * @param postJobOfferDetailRequest The post job offer detail request.
     * @return PostJobOfferDetailResponse The post job offer detail response.
     */
    default PostJobOfferDetailResponse postJobOfferDetail(UUID jobOfferId, PostJobOfferDetailRequest postJobOfferDetailRequest) {
        throw new UnsupportedOperationException(NOT_IMPLEMENTED);
    }
}
