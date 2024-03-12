package com.prx.jobs.backend.api.service;

import com.prx.jobs.backend.api.to.ModeListResponse;
import org.springframework.http.ResponseEntity;

import static com.prx.jobs.backend.util.JobsConstants.NOT_IMPLEMENTED;

/**
 * This is the ModeService interface.
 * It provides methods for managing mode records.
 */
public interface ModeService {

    /**
     * The list method returns a list of ModeTO objects.
     *
     * @param includeInactive A boolean value indicating whether to include inactive status records.
     * @return A ResponseEntity containing a list of ModeTO objects.
     */
    default ResponseEntity<ModeListResponse> list(boolean includeInactive) {
        throw new UnsupportedOperationException(NOT_IMPLEMENTED);
    }
}
