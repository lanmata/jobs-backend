package com.prx.jobs.backend.api.controller;

import com.prx.jobs.backend.api.service.SourceService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.prx.jobs.backend.util.JobsConstants.JOBS_PATH;

/**
 * Company Controller
 */
@Validated
@RestController
@RequestMapping(JOBS_PATH + "/sources")
public class SourceApiController implements SourceApi {

    /**
     * Company Service
     */
    private final SourceService sourceService;

    /**
     * Constructor
     *
     * @param sourceService Company Service
     */
    public SourceApiController(SourceService sourceService) {
        this.sourceService = sourceService;
    }

    @Override
    public SourceService getService() {
        return this.sourceService;
    }
}
