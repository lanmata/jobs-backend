package com.prx.jobs.backend.api.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class TermServiceTest {

    private final TermService termService = new TermService() {
    };

    @Test
    void testList() {
        assertThrows(UnsupportedOperationException.class, () -> termService.list(true));
    }
}
