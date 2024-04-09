package com.prx.jobs.backend.api.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("JobOfferDetailServiceTest")
class JobOfferDetailServiceTest {

    private final JobOfferDetailService jobOfferDetailService = new JobOfferDetailService() {
    };

    @Test
    @DisplayName("Test list method")
    void testList() {
        assertThrows(UnsupportedOperationException.class, () -> jobOfferDetailService.findOfferDetailByJobOfferId(UUID.randomUUID()));
    }

    @Test
    @DisplayName("Test find method")
    void testFind() {
        assertThrows(UnsupportedOperationException.class, () -> jobOfferDetailService.findJobOfferDetailTOByJobOfferId(UUID.randomUUID()));
    }

    @Test
    @DisplayName("Test post method")
    void testPost() {
        assertThrows(UnsupportedOperationException.class, () -> jobOfferDetailService.postJobOfferDetail(UUID.randomUUID(), null));
    }

    @Test
    @DisplayName("Test delete method")
    void testDelete() {
        assertThrows(UnsupportedOperationException.class, () -> jobOfferDetailService.deleteOfferDetail(UUID.randomUUID()));
    }

}
