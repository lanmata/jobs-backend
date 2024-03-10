package com.prx.jobs.backend.api.to;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Represents a request to post a job offer.
 */
public record PostJobOfferRequest(String title, String description, String reference,
                                  UUID companyId, UUID positionId, UUID termId, UUID modeId,
                                  UUID sourceId, UUID statusId, BigDecimal mountRate,
                                  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime dateTime) {
}
