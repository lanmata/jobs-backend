package com.prx.jobs.backend.api.service;

import com.prx.jobs.backend.api.to.StatusListResponse;
import org.springframework.http.ResponseEntity;

import static com.prx.jobs.backend.util.JobsConstants.NOT_IMPLEMENTED;

/**
 * This is the StatusService interface.
 * It provides methods for managing status records.
 */
public interface StatusService {

    /**
     * The list method returns a list of StatusTO objects.
     *
     * @param includeInactive A boolean value indicating whether to include inactive status records.
     * @return A ResponseEntity containing a list of StatusTO objects.
     */
    default ResponseEntity<StatusListResponse> list(boolean includeInactive) {
        throw new UnsupportedOperationException(NOT_IMPLEMENTED);
    }
}
