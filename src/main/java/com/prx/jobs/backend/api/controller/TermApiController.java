package com.prx.jobs.backend.api.controller;

import com.prx.jobs.backend.api.service.TermService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.prx.jobs.backend.util.JobsConstants.JOBS_PATH;

/**
 * Term Controller
 */
@RestController
@RequestMapping(JOBS_PATH + "/terms")
public class TermApiController implements TermApi {

    /**
     * Term Service
     */
    private final TermService termService;


    /**
     * Constructor
     *
     * @param termService Term Service
     */
    public TermApiController(TermService termService) {
        this.termService = termService;
    }

    @Override
    public TermService getService() {
        return this.termService;
    }
}
