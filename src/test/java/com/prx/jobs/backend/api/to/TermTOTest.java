package com.prx.jobs.backend.api.to;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This is a test class for the TermTO record.
 * A record is a special kind of class in Java that is used to model plain data aggregates.
 * <p>
 * The TermTO record has four fields:
 * - id: A UUID that uniquely identifies each instance of TermTO.
 * - name: A String that represents the name of the TermTO.
 * - description: A String that provides a description of the TermTO.
 * - active: A Boolean that indicates whether the TermTO is active or not.
 */
class TermTOTest {

    @Test
    void shouldCreateStatusWithGivenValues() {
        UUID id = UUID.randomUUID();
        TermTO status = new TermTO(id, "name", "description", true);

        assertEquals(id, status.id());
        assertEquals("name", status.name());
        assertEquals("description", status.description());
        assertTrue(status.active());
    }

    @Test
    void shouldHandleNullValues() {
        TermTO status = new TermTO(null, null, null, null);

        assertNull(status.id());
        assertNull(status.name());
        assertNull(status.description());
        assertNull(status.active());
    }

    @Test
    void shouldHandleEmptyStringValues() {
        TermTO status = new TermTO(UUID.randomUUID(), "", "", true);

        assertEquals("", status.name());
        assertEquals("", status.description());
    }

    @Test
    void shouldHandleInactiveStatus() {
        TermTO status = new TermTO(UUID.randomUUID(), "name", "description", false);

        assertFalse(status.active());
    }
}
