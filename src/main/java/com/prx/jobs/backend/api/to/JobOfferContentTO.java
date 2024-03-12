package com.prx.jobs.backend.api.to;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * TO for {@link com.prx.jobs.backend.jpa.entity.JobOfferEntity}
 * & {@link com.prx.jobs.backend.jpa.entity.JobOfferDetailEntity}
 */
public record JobOfferContentTO(@Id UUID id, BigDecimal mount,
                                @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime createdDate,
                                @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime lastModifiedDate,
                                String status, String company, String position, String term,
                                String mode, String source) {
}
