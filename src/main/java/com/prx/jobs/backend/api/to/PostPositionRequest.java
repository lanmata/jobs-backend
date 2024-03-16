package com.prx.jobs.backend.api.to;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * Request object for creating a new position.
 */
public record PostPositionRequest(@NotNull @NotBlank String name, @NotNull @NotBlank String description,
                                  @NotNull @NotBlank Boolean active) {
}
