package com.prx.jobs.backend.api.to;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PostJobOfferResponseTest {

    @Test
    @DisplayName("Should create PostJobOfferResponse with all fields set")
    void shouldCreatePostJobOfferResponseWithAllFieldsSet() {
        UUID id = UUID.randomUUID();
        UUID jobOfferDetailId = UUID.randomUUID();
        LocalDateTime createdDate = LocalDateTime.now();
        String message = "Job offer created successfully";

        PostJobOfferResponse response = new PostJobOfferResponse();
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
    @DisplayName("Should create PostJobOfferResponse with null message, createdDate and jobOfferDetailId")
    void shouldCreatePostJobOfferResponseWithNullMessageCreatedDateAndJobOfferDetailId() {
        UUID id = UUID.randomUUID();

        PostJobOfferResponse response = new PostJobOfferResponse();
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
    @DisplayName("Should create PostJobOfferResponse with null id")
    void shouldCreatePostJobOfferResponseWithNullId() {
        PostJobOfferResponse response = new PostJobOfferResponse();
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
