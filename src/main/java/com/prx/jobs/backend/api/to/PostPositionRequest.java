package com.prx.jobs.backend.api.to;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

/**
 * Request object for creating a new position.
 */
public record PostPositionRequest(
        @NotNull(message = "Name value is null, but is required") @NotBlank(message = "Name is blank, but is required") @NotEmpty String name,
        @NotNull(message = "Description value is null, but is required") @NotBlank(message = "Description value is blank, but is required") @NotEmpty String description,
        @NotNull(message = "Active is null, but is required") @NotBlank(message = "Active is blank, but is required") @NotEmpty Boolean active) {
}
