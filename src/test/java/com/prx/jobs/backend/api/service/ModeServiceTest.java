package com.prx.jobs.backend.api.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ModeServiceTest {

    private final ModeService modeService = new ModeService() {
    };

    @Test
    void testList() {
        assertThrows(UnsupportedOperationException.class, () -> modeService.list(true));
    }
}
