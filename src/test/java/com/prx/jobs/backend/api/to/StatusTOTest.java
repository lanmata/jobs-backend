package com.prx.jobs.backend.api.to;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This is a test class for the StatusTO record.
 * A record is a special kind of class in Java that is used to model plain data aggregates.
 * <p>
 * The StatusTO record has four fields:
 * - id: A UUID that uniquely identifies each instance of StatusTO.
 * - name: A String that represents the name of the StatusTO.
 * - description: A String that provides a description of the StatusTO.
 * - active: A Boolean that indicates whether the StatusTO is active or not.
 */
class StatusTOTest {

    @Test
    void shouldCreateStatusWithGivenValues() {
        UUID id = UUID.randomUUID();
        StatusTO status = new StatusTO(id, "name", "description", true);

        assertEquals(id, status.id());
        assertEquals("name", status.name());
        assertEquals("description", status.description());
        assertTrue(status.active());
    }

    @Test
    void shouldHandleNullValues() {
        StatusTO status = new StatusTO(null, null, null, null);

        assertNull(status.id());
        assertNull(status.name());
        assertNull(status.description());
        assertNull(status.active());
    }

    @Test
    void shouldHandleEmptyStringValues() {
        StatusTO status = new StatusTO(UUID.randomUUID(), "", "", true);

        assertEquals("", status.name());
        assertEquals("", status.description());
    }

    @Test
    void shouldHandleInactiveStatus() {
        StatusTO status = new StatusTO(UUID.randomUUID(), "name", "description", false);

        assertFalse(status.active());
    }
}
