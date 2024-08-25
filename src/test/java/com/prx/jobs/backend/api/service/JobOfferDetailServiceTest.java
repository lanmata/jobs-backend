package com.prx.jobs.backend.api.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.http.HttpStatus.NOT_IMPLEMENTED;

@DisplayName("JobOfferDetailServiceTest")
class JobOfferDetailServiceTest {

    private final JobOfferDetailService jobOfferDetailService = new JobOfferDetailService() {
    };

    @Test
    @DisplayName("Test list method")
    void testList() {
        var response = new ResponseEntity<>(NOT_IMPLEMENTED);
        assertEquals(response, jobOfferDetailService.findOfferDetailByJobOfferId(UUID.randomUUID()));
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
        var response = new ResponseEntity<>(NOT_IMPLEMENTED);
        assertEquals(response, jobOfferDetailService.deleteOfferDetail(UUID.randomUUID()));
    }

}
