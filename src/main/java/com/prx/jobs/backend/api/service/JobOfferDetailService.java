package com.prx.jobs.backend.api.service;

import com.prx.jobs.backend.api.to.JobOfferDetailTO;
import com.prx.jobs.backend.api.to.PostJobOfferDetailRequest;
import com.prx.jobs.backend.api.to.PostJobOfferDetailResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Finds job offer content by job offer id.
     *
     * @param jobOfferId The job offer id to search for.
     * @return Optional<List < JobOfferDetailTO>> The list of job offer details.
     */
    default Optional<List<JobOfferDetailTO>> findJobOfferDetailTOByJobOfferId(UUID jobOfferId) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Posts job offer detail.
     *
     * @param jobOfferId                The job offer id.
     * @param postJobOfferDetailRequest The post job offer detail request.
     * @return ResponseEntity<PostJobOfferDetailResponse> The post job offer detail response.
     */
    default ResponseEntity<PostJobOfferDetailResponse> postJobOfferDetail(UUID jobOfferId, PostJobOfferDetailRequest postJobOfferDetailRequest) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
