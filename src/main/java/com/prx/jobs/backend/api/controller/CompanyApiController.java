package com.prx.jobs.backend.api.controller;

import com.prx.jobs.backend.api.service.CompanyService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.prx.jobs.backend.util.JobsConstants.JOBS_PATH;

/**
 * The CompanyApiController class.
 * This class handles HTTP requests related to companies.
 */
@RestController
@RequestMapping(JOBS_PATH + "/companies")
public class CompanyApiController implements CompanyApi {

    /**
     * The CompanyService instance.
     */
    private final CompanyService companyService;

    /**
     * The CompanyApiController constructor.
     *
     * @param companyService The company service.
     */
    public CompanyApiController(CompanyService companyService) {
        this.companyService = companyService;
    }

    /**
     * Gets the company service.
     *
     * @return The company service.
     */
    @Override
    public CompanyService getService() {
        return this.companyService;
    }
}
