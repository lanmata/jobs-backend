package com.prx.jobs.backend.api.service;

import com.prx.jobs.backend.api.to.PositionListResponse;
import org.springframework.http.ResponseEntity;

import static com.prx.jobs.backend.util.JobsConstants.NOT_IMPLEMENTED;

/**
 * This is the PositionService interface.
 * It provides methods for managing mode records.
 */
public interface PositionService {

    /**
     * The list method returns a list of PositionTO objects.
     *
     * @param includeInactive A boolean value indicating whether to include inactive status records.
     * @return A ResponseEntity containing a list of PositionTO objects.
     */
    default ResponseEntity<PositionListResponse> list(boolean includeInactive) {
        throw new UnsupportedOperationException(NOT_IMPLEMENTED);
    }
}
