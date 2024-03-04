package com.prx.jobs.backend.api.to;

import java.util.List;

/**
 * This is a record class named ModeListResponse.
 * A record is a special kind of class in Java that is used to model plain data aggregates.
 * <p>
 * The ModeListResponse record has one field:
 * - modeCollection: A List of Mode records. Each Mode record in the list represents a unique mode.
 */
public record ModeListResponse(List<ModeTO> modeTOCollection) {

}
