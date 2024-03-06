package com.prx.jobs.backend.api.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class SourceServiceTest {

    private final SourceService sourceService = new SourceService() {
    };

    @Test
    void testList() {
        assertThrows(UnsupportedOperationException.class, () -> sourceService.list(true));
    }
}
