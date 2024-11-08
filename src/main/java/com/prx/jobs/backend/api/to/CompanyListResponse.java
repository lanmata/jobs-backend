package com.prx.jobs.backend.api.to;

import java.util.List;

/**
 * This is a record class named CompanyListResponse.
 * A record is a special kind of class in Java that is used to model plain data aggregates.
 * <p>
 * The CompanyListResponse record has one field:
 * - companyCollection: A List of Company records. Each Company record in the list represents a unique mode.
 */
public record CompanyListResponse(List<CompanyTO> list) {

}
