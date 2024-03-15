package com.prx.jobs.backend.api.to;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.prx.jobs.backend.jpa.entity.JobOfferDetailEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import static com.prx.commons.util.DateUtil.PATTERN_DATE_TIME;

/**
 * TO for {@link JobOfferDetailEntity}
 */
public record JobOfferDetailTO(@NotNull UUID id,
                               @NotNull @NotBlank String description,
                               @JsonFormat(pattern = PATTERN_DATE_TIME) @NotNull LocalDateTime datetime,
                               @NotNull BigDecimal mountRate,
                               @NotNull UUID jobOfferId, @NotNull UUID statusId) {
}
