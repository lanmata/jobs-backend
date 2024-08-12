package com.prx.jobs.backend.api.controller;

import com.prx.jobs.backend.api.service.CompanyService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.prx.jobs.backend.util.JobsConstants.JOBS_PATH;

/**
 * Company Controller
 */
@RestController
@RequestMapping(JOBS_PATH + "/companies")
public class CompanyApiController implements CompanyApi {

    /**
     * Company Service
     */
    private final CompanyService companyService;

    /**
     * Constructor
     *
     * @param companyService Company Service
     */
    public CompanyApiController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @Override
    public CompanyService getService() {
        return companyService;
    }
}
