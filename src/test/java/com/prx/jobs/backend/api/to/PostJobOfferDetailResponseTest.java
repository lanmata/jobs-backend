package com.prx.jobs.backend.api.to;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PostJobOfferDetailResponseTest {

    @Test
    @DisplayName("Should create PostJobOfferDetailResponse with all fields set")
    void shouldCreatePostJobOfferDetailResponseWithAllFieldsSet() {
        UUID id = UUID.randomUUID();
        LocalDateTime createdDate = LocalDateTime.now();
        String message = "Job offer detail created successfully";

        PostJobOfferDetailResponse response = new PostJobOfferDetailResponse(id, createdDate, message);

        assertEquals(id, response.id());
        assertEquals(createdDate, response.createdDate());
        assertEquals(message, response.message());
    }

    @Test
    @DisplayName("Should create PostJobOfferDetailResponse with null message and createdDate")
    void shouldCreatePostJobOfferDetailResponseWithNullMessageAndCreatedDate() {
        UUID id = UUID.randomUUID();

        PostJobOfferDetailResponse response = new PostJobOfferDetailResponse(id, null, null);

        assertEquals(id, response.id());
        assertNotNull(response.createdDate());
        assertEquals("Job offer detail created successfully", response.message());
    }

    @Test
    @DisplayName("Should create PostJobOfferDetailResponse with null id")
    void shouldCreatePostJobOfferDetailResponseWithNullId() {
        PostJobOfferDetailResponse response = new PostJobOfferDetailResponse(null, null, null);

        assertEquals(null, response.id());
        assertEquals(null, response.createdDate());
        assertEquals(null, response.message());
    }
}
