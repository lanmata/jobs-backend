package com.prx.jobs.backend.api.to;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * TO for {@link com.prx.jobs.backend.jpa.entity.JobOfferEntity}
 * & {@link com.prx.jobs.backend.jpa.entity.JobOfferDetailEntity}
 */
public record JobOfferContentTO(@Id UUID id, BigDecimal mount,
                                LocalDateTime createdDate, LocalDateTime lastModifiedDate,
                                String status, String company, String position, String term,
                                String mode, String source) {
}
