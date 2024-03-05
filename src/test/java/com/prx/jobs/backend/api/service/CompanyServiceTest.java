package com.prx.jobs.backend.api.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class CompanyServiceTest {

    private final CompanyService companyService = new CompanyService() {};

    @Test
    void testList() {
        assertThrows(UnsupportedOperationException.class, () -> companyService.list(true));
    }
}
