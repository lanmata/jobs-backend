package com.prx.jobs.backend.api.to;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import static com.prx.commons.util.DateUtil.PATTERN_DATE_TIME;

/**
 * Represents a request to post a job offer.
 */
public record PostJobOfferRequest(String title, String description, String reference,
                                  UUID companyId, UUID positionId, UUID termId, UUID modeId,
                                  UUID sourceId, UUID statusId, BigDecimal mountRate,
                                  @JsonFormat(pattern = PATTERN_DATE_TIME) LocalDateTime dateTime) {
}
