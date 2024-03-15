package com.prx.jobs.backend.api.to;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import static com.prx.commons.util.DateUtil.PATTERN_DATE_TIME;

/**
 * TO for {@link com.prx.jobs.backend.jpa.entity.JobOfferEntity}
 * & {@link com.prx.jobs.backend.jpa.entity.JobOfferDetailEntity}
 */
public record JobOfferContentTO(@Id UUID id, BigDecimal mount,
                                @JsonFormat(pattern = PATTERN_DATE_TIME) LocalDateTime createdDate,
                                @JsonFormat(pattern = PATTERN_DATE_TIME) LocalDateTime lastModifiedDate,
                                String status, String company, String position, String term,
                                String mode, String source) {
}
