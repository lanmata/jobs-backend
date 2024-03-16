package com.prx.jobs.backend.api.to;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class SimpleResponseTest {

    @Test
    void shouldSetDefaultValuesWhenNullsProvided() {
        SimpleResponse response = new SimpleResponse(UUID.randomUUID(), null, null);
        assertNotNull(response.id());
        assertNotNull(response.createdDate());
        assertEquals("Job offer created successfully", response.message());
    }

    @Test
    void shouldSetProvidedValues() {
        UUID id = UUID.randomUUID();
        LocalDateTime now = LocalDateTime.now();
        String message = "Test message";

        SimpleResponse response = new SimpleResponse(id, now, message);

        assertEquals(id, response.id());
        assertEquals(now, response.createdDate());
        assertEquals(message, response.message());
    }

    @Test
    void shouldSetDefaultMessageWhenNullMessageProvided() {
        UUID id = UUID.randomUUID();
        LocalDateTime now = LocalDateTime.now();

        SimpleResponse response = new SimpleResponse(id, now, null);

        assertEquals(id, response.id());
        assertEquals(now, response.createdDate());
        assertEquals("Job offer created successfully", response.message());
    }

    @Test
    void shouldSetDefaultCreatedDateWhenNullCreatedDateProvided() {
        UUID id = UUID.randomUUID();
        String message = "Test message";

        SimpleResponse response = new SimpleResponse(id, null, message);

        assertEquals(id, response.id());
        assertNotNull(response.createdDate());
        assertEquals(message, response.message());
    }
}