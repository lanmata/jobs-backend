package com.prx.jobs.backend.api.to;

import java.util.List;

/**
 * This is a record class named PositionListResponse.
 * A record is a special kind of class in Java that is used to model plain data aggregates.
 * <p>
 * The PositionListResponse record has one field:
 * - positionCollection: A List of Position records. Each Position record in the list represents a unique mode.
 */
public record PositionListResponse(List<PositionTO> positionTOCollection) {

}
