package com.prx.jobs.backend.api.to;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This is a test class for the PositionTO  record.
 * A record is a special kind of class in Java that is used to model plain data aggregates.
 * <p>
 * The PositionTO  record has four fields:
 * - id: A UUID that uniquely identifies each instance of PositionTO .
 * - name: A String that represents the name of the PositionTO .
 * - description: A String that provides a description of the PositionTO .
 * - active: A Boolean that indicates whether the PositionTO  is active or not.
 */
class PositionTOTest {

    @Test
    void shouldCreatePositionWithGivenValues() {
        UUID id = UUID.randomUUID();
        PositionTO PositionTO = new PositionTO(id, "name", "description", true);

        assertEquals(id, PositionTO.id());
        assertEquals("name", PositionTO.name());
        assertEquals("description", PositionTO.description());
        assertTrue(PositionTO.active());
    }

    @Test
    void shouldHandleNullValues() {
        PositionTO PositionTO = new PositionTO(null, null, null, null);

        assertNull(PositionTO.id());
        assertNull(PositionTO.name());
        assertNull(PositionTO.description());
        assertNull(PositionTO.active());
    }

    @Test
    void shouldHandleEmptyStringValues() {
        PositionTO PositionTO = new PositionTO(UUID.randomUUID(), "", "", true);

        assertEquals("", PositionTO.name());
        assertEquals("", PositionTO.description());
    }

    @Test
    void shouldHandleInactivePosition() {
        PositionTO PositionTO = new PositionTO(UUID.randomUUID(), "name", "description", false);

        assertFalse(PositionTO.active());
    }
}
