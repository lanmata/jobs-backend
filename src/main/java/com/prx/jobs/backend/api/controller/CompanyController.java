package com.prx.jobs.backend.api.controller;

import com.prx.jobs.backend.api.service.CompanyService;
import com.prx.jobs.backend.api.to.CompanyListResponse;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Company Controller
 */
@RestController
@RequestMapping("/v1/companies")
public class CompanyController {

    /**
     * Company Service
     */
    private final CompanyService companyService;

    /**
     * Constructor
     *
     * @param companyService Company Service
     */
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    /**
     * List all companies
     *
     * @param includeInactive Include Inactive
     * @return Company List Response
     */
    @GetMapping(produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<CompanyListResponse> list(@PathParam(value = "includeInactive") boolean includeInactive) {
        return this.companyService.list(includeInactive);
    }
}
