package com.prx.jobs.backend.api.to;

import java.util.UUID;

/**
 * This is a record class named Mode.
 * A record is a special kind of class in Java that is used to model plain data aggregates.
 * <p>
 * The Mode record has four fields:
 * - id: A UUID that uniquely identifies each instance of Mode.
 * - name: A String that represents the name of the Mode.
 * - description: A String that provides a description of the Mode.
 * - active: A Boolean that indicates whether the Mode is active or not.
 */
public record ModeTO(UUID id, String name, String description, Boolean active ) {
}
