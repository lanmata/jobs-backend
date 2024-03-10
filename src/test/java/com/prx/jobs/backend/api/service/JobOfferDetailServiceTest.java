package com.prx.jobs.backend.api.service;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertThrows;

class JobOfferDetailServiceTest {

    private final JobOfferDetailService jobOfferDetailService = new JobOfferDetailService() {
    };

    @Test
    void testList() {
        assertThrows(UnsupportedOperationException.class, () -> jobOfferDetailService.findOfferDetailByJobOfferId(UUID.randomUUID()));
    }

}
