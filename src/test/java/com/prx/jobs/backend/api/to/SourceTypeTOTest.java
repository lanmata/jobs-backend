package com.prx.jobs.backend.api.to;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This is a test class for the SourceTypeTO record.
 * A record is a special kind of class in Java that is used to model plain data aggregates.
 * <p>
 * The SourceTypeTO record has four fields:
 * - id: A UUID that uniquely identifies each instance of SourceTypeTO.
 * - name: A String that represents the name of the SourceTypeTO.
 * - description: A String that provides a description of the SourceTypeTO.
 * - active: A Boolean that indicates whether the SourceTypeTO is active or not.
 */
class SourceTypeTOTest {

    @Test
    void shouldCreateSourceTypeWithGivenValues() {
        UUID id = UUID.randomUUID();
        SourceTypeTO sourceTypeTO = new SourceTypeTO(id, "name", "description", true);

        assertEquals(id, sourceTypeTO.id());
        assertEquals("name", sourceTypeTO.name());
        assertEquals("description", sourceTypeTO.description());
        assertTrue(sourceTypeTO.active());
    }

    @Test
    void shouldHandleNullValues() {
        SourceTypeTO sourceTypeTO = new SourceTypeTO(null, null, null, null);

        assertNull(sourceTypeTO.id());
        assertNull(sourceTypeTO.name());
        assertNull(sourceTypeTO.description());
        assertNull(sourceTypeTO.active());
    }

    @Test
    void shouldHandleEmptyStringValues() {
        SourceTypeTO sourceTypeTO = new SourceTypeTO(UUID.randomUUID(), "", "", true);

        assertEquals("", sourceTypeTO.name());
        assertEquals("", sourceTypeTO.description());
    }

    @Test
    void shouldHandleInactiveSourceType() {
        SourceTypeTO sourceTypeTO = new SourceTypeTO(UUID.randomUUID(), "name", "description", false);

        assertFalse(sourceTypeTO.active());
    }
}
