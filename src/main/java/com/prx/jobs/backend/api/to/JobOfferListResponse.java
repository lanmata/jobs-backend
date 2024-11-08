package com.prx.jobs.backend.api.to;

import java.util.List;

/**
 * This is a record class named JobOfferListResponse.
 * A record is a special kind of class in Java that is used to model plain data aggregates.
 * <p>
 * The JobOfferListResponse record has one field:
 * - list: A List of {@link JobOfferContentTO} records. Each {@link JobOfferContentTO} record in the list represents a unique job offer.
 *
 * @author Luis Mata
 */
public record JobOfferListResponse(List<JobOfferContentTO> list) {
}
