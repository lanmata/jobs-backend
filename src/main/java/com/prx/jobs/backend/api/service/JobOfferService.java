package com.prx.jobs.backend.api.service;

import com.prx.jobs.backend.api.to.*;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

import static com.prx.jobs.backend.util.JobsConstants.NOT_IMPLEMENTED;

/**
 * This is the JobOfferService interface.
 * It provides methods for managing job offer records.
 */
public interface JobOfferService {

    /**
     * Finds job offer content by job offer id.
     *
     * @return ResponseEntity<List < JobOfferContentTO>>.
     */
    default ResponseEntity<List<JobOfferContentTO>> findJobOfferContent() {
        throw new UnsupportedOperationException(NOT_IMPLEMENTED);
    }

    /**
     * Finds job offer content by job offer id.
     *
     * @param jobOfferId The job offer id.
     * @return ResponseEntity<GetJobOfferResponse>.
     */
    default ResponseEntity<GetJobOfferResponse> findJobOfferContentByJobOfferId(UUID jobOfferId) {
        throw new UnsupportedOperationException(NOT_IMPLEMENTED);
    }

    /**
     * Creates a job offer.
     *
     * @param postJobOfferRequest The post job offer request.
     * @return ResponseEntity<PostJobOfferResponse>.
     */
    default ResponseEntity<SimpleResponse> createJobOffer(PostJobOfferRequest postJobOfferRequest) {
        throw new UnsupportedOperationException(NOT_IMPLEMENTED);
    }

    /**
     * Updates a job offer.
     *
     * @param uuid                The job offer id.
     * @param putJobOfferRequest The put job offer request.
     * @return ResponseEntity<PutJobOfferResponse> The job offer response.
     */
    default ResponseEntity<PutJobOfferResponse> updateJobOffer(UUID uuid, PutJobOfferRequest putJobOfferRequest) {
        throw new UnsupportedOperationException(NOT_IMPLEMENTED);
    }
}
