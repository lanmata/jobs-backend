package com.prx.jobs.backend.api.to;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.UUID;

import static com.prx.commons.util.DateUtil.PATTERN_DATE_TIME;

/**
 * Response for put job offer operation.
 */
public class PutJobOfferResponse {
    private UUID id;
    private UUID jobOfferDetailId;
    @JsonFormat(pattern = PATTERN_DATE_TIME)
    private LocalDateTime createdDate;
    private String message;

    /**
     * Default constructor.
     */
    public PutJobOfferResponse() {
        // Default constructor.
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getJobOfferDetailId() {
        return jobOfferDetailId;
    }

    public void setJobOfferDetailId(UUID jobOfferDetailId) {
        this.jobOfferDetailId = jobOfferDetailId;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
