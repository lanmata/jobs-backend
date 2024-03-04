package com.prx.jobs.backend.api.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class StatusServiceTest {

    private final StatusService statusService = new StatusService() {};

    @Test
    void testList() {
        assertThrows(UnsupportedOperationException.class, () -> statusService.list(true));
    }
}
