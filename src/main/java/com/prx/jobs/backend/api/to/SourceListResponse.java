package com.prx.jobs.backend.api.to;

import java.util.List;

/**
 * This is a record class named SourceListResponse.
 * A record is a special kind of class in Java that is used to model plain data aggregates.
 * <p>
 * The SourceListResponse record has one field:
 * - statusCollection: A List of SourceTO records. Each Source record in the list represents a unique source type.
 */
public record SourceListResponse(List<SourceTO> list) {
}
