package com.prx.jobs.backend.api.to;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This is a test class for the SourceTO record.
 * A record is a special kind of class in Java that is used to model plain data aggregates.
 * <p>
 * The SourceTO record has four fields:
 * - id: A UUID that uniquely identifies each instance of SourceTO.
 * - name: A String that represents the name of the SourceTO.
 * - description: A String that provides a description of the SourceTO.
 * - active: A Boolean that indicates whether the SourceTO is active or not.
 */
class SourceTOTest {

    @Test
    void shouldCreateSourceWithGivenValues() {
        UUID id = UUID.randomUUID();
        SourceTO sourceTO = new SourceTO(id, "name", "description", true, id);

        assertEquals(id, sourceTO.id());
        assertEquals("name", sourceTO.name());
        assertEquals("description", sourceTO.description());
        assertTrue(sourceTO.active());
    }

    @Test
    void shouldHandleNullValues() {
        SourceTO sourceTO = new SourceTO(null, null, null, null, null);

        assertNull(sourceTO.id());
        assertNull(sourceTO.name());
        assertNull(sourceTO.description());
        assertNull(sourceTO.active());
    }

    @Test
    void shouldHandleEmptyStringValues() {
        SourceTO sourceTO = new SourceTO(UUID.randomUUID(), "", "", true, UUID.randomUUID());

        assertEquals("", sourceTO.name());
        assertEquals("", sourceTO.description());
    }

    @Test
    void shouldHandleInactiveSource() {
        SourceTO sourceTO = new SourceTO(UUID.randomUUID(), "name", "description", false, null);

        assertFalse(sourceTO.active());
    }
}
