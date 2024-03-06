package com.prx.jobs.backend.api.service;

import com.prx.jobs.backend.api.to.SourceListResponse;
import org.springframework.http.ResponseEntity;

/**
 * This is the SourceService interface.
 * It provides methods for managing term records.
 */
public interface SourceService {

    /**
     * The list method returns a list of SourceTO objects.
     *
     * @param includeInactive A boolean value indicating whether to include inactive source type records.
     * @return A ResponseEntity containing a list of SourceTO objects.
     */
    default ResponseEntity<SourceListResponse> list(boolean includeInactive) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
