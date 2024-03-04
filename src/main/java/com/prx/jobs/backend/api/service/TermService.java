package com.prx.jobs.backend.api.service;

import com.prx.jobs.backend.api.to.TermListResponse;
import org.springframework.http.ResponseEntity;

/**
 * This is the TermService interface.
 * It provides methods for managing term records.
 */
public interface TermService {

    /**
     * The list method returns a list of TermTO objects.
     *
     * @param includeInactive A boolean value indicating whether to include inactive status records.
     * @return A ResponseEntity containing a list of TermTO objects.
     */
    default ResponseEntity<TermListResponse> list(boolean includeInactive) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
