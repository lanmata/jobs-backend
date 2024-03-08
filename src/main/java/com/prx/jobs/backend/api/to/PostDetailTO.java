package com.prx.jobs.backend.api.to;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * TO for {@link com.prx.jobs.backend.jpa.entity.PostDetailEntity}
 */
public record PostDetailTO(@NotNull UUID id,
                           @NotNull @NotBlank String description,
                           @NotNull LocalDateTime datetime,
                           @NotNull BigDecimal mountRate,
                           @NotNull UUID postId, @NotNull UUID statusId) {
}
