package com.prx.jobs.backend.api.to;

import java.util.List;

/**
 * This is a record class named SourceTypeListResponse.
 * A record is a special kind of class in Java that is used to model plain data aggregates.
 * <p>
 * The SourceTypeListResponse record has one field:
 * - statusCollection: A List of SourceTypeTO records. Each SourceType record in the list represents a unique source type.
 */
public record SourceTypeListResponse(List<SourceTypeTO> sourceTypeCollection) {
}
