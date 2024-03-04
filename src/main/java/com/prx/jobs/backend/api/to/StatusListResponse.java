package com.prx.jobs.backend.api.to;

import java.util.List;

/**
 * This is a record class named StatusListResponse.
 * A record is a special kind of class in Java that is used to model plain data aggregates.
 * <p>
 * The StatusListResponse record has one field:
 * - statusCollection: A List of Status records. Each Status record in the list represents a unique status.
 */
public record StatusListResponse(List<StatusTO> statusTOCollection) {
}
