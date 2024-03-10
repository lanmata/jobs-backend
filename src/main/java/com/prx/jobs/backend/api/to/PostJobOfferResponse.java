package com.prx.jobs.backend.api.to;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

/**
 * Response for post job offer operation.
 */
public record PostJobOfferResponse(UUID id, LocalDateTime createdDate, String message) {

    /**
     * The PostJobOfferResponse constructor.
     *
     * @param id          The id.
     * @param createdDate The created date.
     * @param message     The message.
     */
    public PostJobOfferResponse {
        if (Objects.nonNull(id)) {
            if (Objects.isNull(message)) {
                message = "Job offer created successfully";
            }
            if (Objects.isNull(createdDate)) {
                createdDate = LocalDateTime.now();
            }
        }
    }
}
