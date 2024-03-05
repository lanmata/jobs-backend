package com.prx.jobs.backend.api.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class PositionServiceTest {

    private final PositionService positionService = new PositionService() {};

    @Test
    void testList() {
        assertThrows(UnsupportedOperationException.class, () -> positionService.list(true));
    }
}
