package com.prx.jobs.backend.api.service;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CompanyServiceTest {

    private final CompanyService companyService = new CompanyService() {
    };

    @Test
    void testList() {
        var responseEntity = new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
        assertEquals(responseEntity, companyService.list(true));
    }
}
