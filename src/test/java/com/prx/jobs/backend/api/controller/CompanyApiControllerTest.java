package com.prx.jobs.backend.api.controller;

import com.prx.jobs.backend.api.service.CompanyService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class CompanyApiControllerTest {

    @Test
    void getServiceTest() {
        var service = new CompanyApiController(new CompanyService() {});
        assertNotNull(service);
    }
}
