package com.prx.jobs.backend.api.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class PositionServiceTest {

    private final PositionService positionService = new PositionService() {
    };

    @Test
    @DisplayName("Test list method")
    void testList() {
        assertThrows(UnsupportedOperationException.class, () -> positionService.list(true));
    }

    @Test
    @DisplayName("Test save method")
    void testSave() {
        assertThrows(UnsupportedOperationException.class, () -> positionService.save(null));
    }
}
