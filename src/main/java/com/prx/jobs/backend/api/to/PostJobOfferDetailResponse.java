package com.prx.jobs.backend.api.to;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import static com.prx.commons.util.DateUtil.PATTERN_DATE_TIME;

/**
 * Response for post job offer detail operation.
 */
public record PostJobOfferDetailResponse(UUID id,
                                         @JsonFormat(pattern = PATTERN_DATE_TIME) LocalDateTime createdDate,
                                         String message) {

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
