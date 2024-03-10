package com.prx.jobs.backend.api.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class JobOfferServiceTest {

    private final JobOfferService jobOfferService = new JobOfferService() {
    };

    @Test
    void testList() {
        assertThrows(UnsupportedOperationException.class, jobOfferService::findJobOfferContent);
    }
}
