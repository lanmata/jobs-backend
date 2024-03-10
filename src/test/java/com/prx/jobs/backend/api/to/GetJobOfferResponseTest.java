package com.prx.jobs.backend.api.to;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class GetJobOfferResponseTest {

    @Test
    void shouldCreateGetPostResponseWithNonNullId() {
        UUID id = UUID.randomUUID();
        GetJobOfferResponse response = new GetJobOfferResponse(id, "title", "description",
                "reference", UUID.randomUUID(), "company",
                UUID.randomUUID(), "position",
                UUID.randomUUID(), "term", UUID.randomUUID(), "mode",
                UUID.randomUUID(), "source", null);
        assertNotNull(response.id());
        assertEquals(id, response.id());
    }

    @Test
    void shouldCreateGetPostResponseWithNonNullTitle() {
        String title = "Test Title";
        GetJobOfferResponse response = new GetJobOfferResponse(UUID.randomUUID(), title, "description",
                "reference", UUID.randomUUID(), "company",
                UUID.randomUUID(), "position",
                UUID.randomUUID(), "term", UUID.randomUUID(), "mode",
                UUID.randomUUID(), "source", null);
        assertNotNull(response.title());
        assertEquals(title, response.title());
    }

    @Test
    void shouldCreateGetPostResponseWithNonNullDescription() {
        String description = "Test Description";
        GetJobOfferResponse response = new GetJobOfferResponse(UUID.randomUUID(), "title", description,
                "reference", UUID.randomUUID(), "company",
                UUID.randomUUID(), "position",
                UUID.randomUUID(), "term", UUID.randomUUID(), "mode",
                UUID.randomUUID(), "source", null);
        assertNotNull(response.description());
        assertEquals(description, response.description());
    }

    @Test
    void shouldCreateGetPostResponseWithEmptyPostDetailListWhenNullIsPassed() {
        GetJobOfferResponse response = new GetJobOfferResponse(UUID.randomUUID(), "title", "description",
                "reference", UUID.randomUUID(), "company",
                UUID.randomUUID(), "position",
                UUID.randomUUID(), "term", UUID.randomUUID(), "mode",
                UUID.randomUUID(), "source", Collections.emptyList());
        assertNotNull(response.postDetailList());
        assertTrue(response.postDetailList().isEmpty());
    }
}
