package com.prx.jobs.backend.api.to;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PutJobOfferResponseTest {

    @Test
    @DisplayName("Should create PutJobOfferResponse with all fields set")
    void shouldCreatePutJobOfferResponseWithAllFieldsSet() {
        UUID id = UUID.randomUUID();
        UUID jobOfferDetailId = UUID.randomUUID();
        LocalDateTime createdDate = LocalDateTime.now();
        String message = "Job offer updated successfully";

        PutJobOfferResponse response = new PutJobOfferResponse();
        response.setId(id);
        response.setJobOfferDetailId(jobOfferDetailId);
        response.setCreatedDate(createdDate);
        response.setMessage(message);

        assertEquals(id, response.getId());
        assertEquals(jobOfferDetailId, response.getJobOfferDetailId());
        assertEquals(createdDate, response.getCreatedDate());
        assertEquals(message, response.getMessage());
    }

    @Test
    @DisplayName("Should create PutJobOfferResponse with null message, createdDate and jobOfferDetailId")
    void shouldCreatePutJobOfferResponseWithNullMessageCreatedDateAndJobOfferDetailId() {
        UUID id = UUID.randomUUID();

        PutJobOfferResponse response = new PutJobOfferResponse();
        response.setId(id);
        response.setJobOfferDetailId(null);
        response.setCreatedDate(null);
        response.setMessage(null);

        assertEquals(id, response.getId());
        assertEquals(null, response.getJobOfferDetailId());
        assertEquals(null, response.getCreatedDate());
        assertEquals(null, response.getMessage());
    }

    @Test
    @DisplayName("Should create PutJobOfferResponse with null id")
    void shouldCreatePutJobOfferResponseWithNullId() {
        PutJobOfferResponse response = new PutJobOfferResponse();
        response.setId(null);
        response.setJobOfferDetailId(null);
        response.setCreatedDate(null);
        response.setMessage(null);

        assertEquals(null, response.getId());
        assertEquals(null, response.getJobOfferDetailId());
        assertEquals(null, response.getCreatedDate());
        assertEquals(null, response.getMessage());
    }
}
