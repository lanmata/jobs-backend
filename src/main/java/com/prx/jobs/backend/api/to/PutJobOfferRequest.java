package com.prx.jobs.backend.api.to;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import static com.prx.commons.util.DateUtil.PATTERN_DATE_TIME;

/**
 * Represents a request to put a job offer.
 */
public record PutJobOfferRequest(UUID companyId, UUID modeId, UUID termId,
                                 UUID sourceId, UUID statusId, BigDecimal mountRate, String description,
                                 @JsonFormat(pattern = PATTERN_DATE_TIME) LocalDateTime createdDateTime) {
}
