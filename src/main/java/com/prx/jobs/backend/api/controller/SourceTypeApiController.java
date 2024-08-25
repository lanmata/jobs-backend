package com.prx.jobs.backend.api.controller;

import com.prx.jobs.backend.api.service.SourceTypeService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.prx.jobs.backend.util.JobsConstants.JOBS_PATH;

/**
 * Company Controller
 */
@Validated
@RestController
@RequestMapping(JOBS_PATH + "/source-types")
public class SourceTypeApiController implements SourceTypeApi {

    /**
     * Company Service
     */
    private final SourceTypeService sourceTypeService;

    /**
     * Constructor
     *
     * @param sourceTypeService Company Service
     */
    public SourceTypeApiController(SourceTypeService sourceTypeService) {
        this.sourceTypeService = sourceTypeService;
    }

    public SourceTypeService getService() {
        return this.sourceTypeService;
    }

}
