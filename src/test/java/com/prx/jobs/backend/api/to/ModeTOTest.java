package com.prx.jobs.backend.api.to;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This is a test class for the ModeTO record.
 * A record is a special kind of class in Java that is used to model plain data aggregates.
 * <p>
 * The ModeTO record has four fields:
 * - id: A UUID that uniquely identifies each instance of ModeTO.
 * - name: A String that represents the name of the ModeTO.
 * - description: A String that provides a description of the ModeTO.
 * - active: A Boolean that indicates whether the ModeTO is active or not.
 */
class ModeTOTest {

    @Test
    void shouldCreateStatusWithGivenValues() {
        UUID id = UUID.randomUUID();
        ModeTO modeTO = new ModeTO(id, "name", "description", true);

        assertEquals(id, modeTO.id());
        assertEquals("name", modeTO.name());
        assertEquals("description", modeTO.description());
        assertTrue(modeTO.active());
    }

    @Test
    void shouldHandleNullValues() {
        ModeTO modeTO = new ModeTO(null, null, null, null);

        assertNull(modeTO.id());
        assertNull(modeTO.name());
        assertNull(modeTO.description());
        assertNull(modeTO.active());
    }

    @Test
    void shouldHandleEmptyStringValues() {
        ModeTO modeTO = new ModeTO(UUID.randomUUID(), "", "", true);

        assertEquals("", modeTO.name());
        assertEquals("", modeTO.description());
    }

    @Test
    void shouldHandleInactiveStatus() {
        ModeTO modeTO = new ModeTO(UUID.randomUUID(), "name", "description", false);

        assertFalse(modeTO.active());
    }
}
