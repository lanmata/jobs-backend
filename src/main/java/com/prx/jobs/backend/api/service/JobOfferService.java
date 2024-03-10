package com.prx.jobs.backend.api.service;

import com.prx.jobs.backend.api.to.GetJobOfferResponse;
import com.prx.jobs.backend.api.to.JobOfferContentTO;
import com.prx.jobs.backend.api.to.PostJobOfferRequest;
import com.prx.jobs.backend.api.to.PostJobOfferResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

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
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Finds job offer content by job offer id.
     *
     * @param jobOfferId The job offer id.
     * @return ResponseEntity<GetJobOfferResponse>.
     */
    default ResponseEntity<GetJobOfferResponse> findJobOfferContentByJobOfferId(UUID jobOfferId) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Creates a job offer.
     *
     * @param postJobOfferRequest The post job offer request.
     * @return ResponseEntity<PostJobOfferResponse>.
     */
    default ResponseEntity<PostJobOfferResponse> createJobOffer(PostJobOfferRequest postJobOfferRequest) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
