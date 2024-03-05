package com.prx.jobs.backend.api.to;

import java.util.UUID;

/**
 * This is a record class named Position.
 * A record is a special kind of class in Java that is used to model plain data aggregates.
 * <p>
 * The Position record has four fields:
 * - id: A UUID that uniquely identifies each instance of Position.
 * - name: A String that represents the name of the Position.
 * - description: A String that provides a description of the Position.
 * - active: A Boolean that indicates whether the Position is active or not.
 */
public record PositionTO(UUID id, String name, String description, Boolean active ) {
}
