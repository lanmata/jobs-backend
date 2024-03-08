package com.prx.jobs.backend.api.to;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class GetPostResponseTest {

    @Test
    void shouldCreateGetPostResponseWithNonNullId() {
        UUID id = UUID.randomUUID();
        GetPostResponse response = new GetPostResponse(id, "title", "description",
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
        GetPostResponse response = new GetPostResponse(UUID.randomUUID(), title, "description",
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
        GetPostResponse response = new GetPostResponse(UUID.randomUUID(), "title", description,
                "reference", UUID.randomUUID(), "company",
                UUID.randomUUID(), "position",
                UUID.randomUUID(), "term", UUID.randomUUID(), "mode",
                UUID.randomUUID(), "source", null);
        assertNotNull(response.description());
        assertEquals(description, response.description());
    }

    @Test
    void shouldCreateGetPostResponseWithEmptyPostDetailListWhenNullIsPassed() {
        GetPostResponse response = new GetPostResponse(UUID.randomUUID(), "title", "description",
                "reference", UUID.randomUUID(), "company",
                UUID.randomUUID(), "position",
                UUID.randomUUID(), "term", UUID.randomUUID(), "mode",
                UUID.randomUUID(), "source", Collections.emptyList());
        assertNotNull(response.postDetailList());
        assertTrue(response.postDetailList().isEmpty());
    }
}
