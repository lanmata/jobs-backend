package com.prx.jobs.backend.api.service;

import com.prx.jobs.backend.api.to.CompanyListResponse;
import org.springframework.http.ResponseEntity;

import static com.prx.jobs.backend.util.JobsConstants.NOT_IMPLEMENTED;

/**
 * This is the CompanyService interface.
 * It provides methods for managing term records.
 */
public interface CompanyService {

    /**
     * The list method returns a list of CompanyTO objects.
     *
     * @param includeInactive A boolean value indicating whether to include inactive status records.
     * @return A ResponseEntity containing a list of CompanyTO objects.
     * @openapi /companies:
     * get:
     * summary: Retrieve a list of companies
     * description: Returns a list of CompanyTO objects. Optionally includes inactive companies.
     * parameters:
     * - in: query
     * name: includeInactive
     * schema:
     * type: boolean
     * description: A boolean value indicating whether to include inactive status records.
     * responses:
     * 200:
     * description: A list of companies
     * content:
     * application/json:
     * schema:
     * type: array
     * items:
     * $ref: '#/components/schemas/CompanyTO'
     * 501:
     * description: Not implemented
     */
    default ResponseEntity<CompanyListResponse> list(boolean includeInactive) {
        throw new UnsupportedOperationException(NOT_IMPLEMENTED);
    }
}
