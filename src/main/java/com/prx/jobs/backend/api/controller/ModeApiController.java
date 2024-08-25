package com.prx.jobs.backend.api.controller;

import com.prx.jobs.backend.api.service.ModeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.prx.jobs.backend.util.JobsConstants.JOBS_PATH;

/**
 * Mode Controller
 */
@RestController
@RequestMapping(JOBS_PATH + "/modes")
public class ModeApiController implements  ModeApi {

    /**
     * Mode Service
     */
    private final ModeService modeService;

    /**
     * Constructor
     *
     * @param modeService Mode Service
     */
    public ModeApiController(ModeService modeService) {
        this.modeService = modeService;
    }

    @Override
    public ModeService getService() {
        return this.modeService;
    }
}
