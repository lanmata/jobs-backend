package com.prx.jobs.backend.api.to;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

/**
 * Response for post job offer detail operation.
 */
public record PostJobOfferDetailResponse(UUID id, LocalDateTime createdDate, String message) {

    /**
     * The PostJobOfferDetailResponse constructor.
     *
     * @param id          The id.
     * @param createdDate The created date.
     * @param message     The message.
     */
    public PostJobOfferDetailResponse {
        if (Objects.nonNull(id)) {
            if (Objects.isNull(message)) {
                message = "Job offer detail created successfully";
            }
            if (Objects.isNull(createdDate)) {
                createdDate = LocalDateTime.now();
            }
        }
    }
}
