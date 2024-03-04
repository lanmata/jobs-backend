package com.prx.jobs.backend.api.to;

import java.util.List;

/**
 * This is a record class named TermListResponse.
 * A record is a special kind of class in Java that is used to model plain data aggregates.
 * <p>
 * The StatusListResponse record has one field:
 * - termTOCollection: A List of Term records. Each Term record in the list represents a unique term.
 */
public record TermListResponse(List<TermTO> termTOCollection) {
}
