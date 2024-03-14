package com.prx.jobs.backend.api.to;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.util.UUID;

/**
 * This is a record class named SourceTypeTO.
 * A record is a special kind of class in Java that is used to model plain data aggregates.
 * <p>
 * The SourceTypeTO record has four fields:
 * - id: A UUID that uniquely identifies each instance of SourceType.
 * - name: A String that represents the name of the SourceType.
 * - description: A String that provides a description of the SourceType.
 * - active: A Boolean that indicates whether the SourceType is active or not.
 */
public record SourceTypeTO(UUID id, @NotNull @Size(min = 5, max = 60) @NotBlank String name,
                           @NotNull @Size(min = 5, max = 255) @NotBlank String description,
                           Boolean active) implements Serializable {
}
