package com.prx.jobs.backend.api.to;

import java.util.UUID;

/**
 * This is a record class named Company.
 * A record is a special kind of class in Java that is used to model plain data aggregates.
 * <p>
 * The Company record has four fields:
 * - id: A UUID that uniquely identifies each instance of Company.
 * - name: A String that represents the name of the Company.
 * - description: A String that provides a description of the Company.
 * - active: A Boolean that indicates whether the Company is active or not.
 */
public record CompanyTO(UUID id, String name, String description, Boolean active ) {
}
