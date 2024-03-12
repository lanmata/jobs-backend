package com.prx.jobs.backend.api.to;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Represents a request to put a job offer.
 */
public record PutJobOfferRequest(UUID companyId, UUID modeId, UUID termId,
                                 UUID sourceId, UUID statusId, BigDecimal mountRate, String description,
                                 @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime createdDateTime) {
}
