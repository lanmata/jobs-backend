package com.prx.jobs.backend.api.to;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.util.UUID;

/**
 * TO for {@link com.prx.jobs.backend.jpa.entity.SourceEntity}
 */
public record SourceTO(UUID id, @NotNull @Size(min = 5, max = 60) @NotBlank String name,
                       @NotNull @Size(min = 5, max = 255) @NotBlank String description, @NotNull Boolean active,
                       @NotNull UUID sourceType) implements Serializable {
}
