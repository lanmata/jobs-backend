package com.prx.jobs.backend.api.controller;

import com.prx.jobs.backend.api.service.StatusService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.prx.jobs.backend.util.JobsConstants.JOBS_PATH;

/**
 * Status Controller
 */
@RestController
@RequestMapping(JOBS_PATH + "/status")
public class StatusApiController implements StatusApi {

    /**
     * Status Service
     */
    private final StatusService statusService;

    /**
     * Constructor
     *
     * @param statusService boolean value
     */
    public StatusApiController(StatusService statusService) {
        this.statusService = statusService;
    }

    @Override
    public StatusService getService() {
        return this.statusService;
    }
}
