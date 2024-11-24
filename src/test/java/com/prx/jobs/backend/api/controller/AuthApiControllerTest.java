package com.prx.jobs.backend.api.controller;

import com.prx.jobs.backend.api.service.AuthService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class AuthApiControllerTest {

    @Test
    void getServiceTest() {
        var service = new AuthApiController(new AuthService() {
        });
        assertNotNull(service);
    }
}
