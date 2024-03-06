package com.prx.jobs.backend.api.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class SourceTypeServiceTest {

    private final SourceTypeService sourceTypeService = new SourceTypeService() {
    };

    @Test
    void testList() {
        assertThrows(UnsupportedOperationException.class, () -> sourceTypeService.list(true));
    }
}
