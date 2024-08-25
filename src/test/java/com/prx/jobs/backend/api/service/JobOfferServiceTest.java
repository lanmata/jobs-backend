package com.prx.jobs.backend.api.service;

import com.prx.jobs.backend.api.to.PostJobOfferRequest;
import com.prx.jobs.backend.api.to.PutJobOfferRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("JobOfferServiceTest")
class JobOfferServiceTest {

    private final JobOfferService jobOfferService = new JobOfferService() {
    };

    @Test
    void testList() {
        var response = new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
        assertEquals(response, jobOfferService.findJobOfferContent());
    }

    @Test
    void testFind() {
        var response = new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
        assertEquals(response, jobOfferService.findJobOfferContentByJobOfferId(UUID.randomUUID()));
    }

    @Test
    void testCreate() {
        var response = new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
        assertEquals(response, jobOfferService.createJobOffer(new PostJobOfferRequest("Title", "Description",
                "Reference", UUID.randomUUID(), UUID.randomUUID(), UUID.randomUUID(), UUID.randomUUID(),
                UUID.randomUUID(), UUID.randomUUID(), BigDecimal.ONE, LocalDateTime.MAX)));
    }

    @Test
    void testPut() {
        var response = new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
        assertEquals(response, jobOfferService.updateJobOffer(UUID.randomUUID(), new PutJobOfferRequest(UUID.randomUUID(),
                UUID.randomUUID(), UUID.randomUUID(), UUID.randomUUID(), UUID.randomUUID(), BigDecimal.ONE,
                "Description", LocalDateTime.MAX)));
    }
}
