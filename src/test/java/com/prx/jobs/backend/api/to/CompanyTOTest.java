package com.prx.jobs.backend.api.to;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This is a test class for the CompanyTO record.
 * A record is a special kind of class in Java that is used to model plain data aggregates.
 * <p>
 * The CompanyTO record has four fields:
 * - id: A UUID that uniquely identifies each instance of CompanyTO.
 * - name: A String that represents the name of the CompanyTO.
 * - description: A String that provides a description of the CompanyTO.
 * - active: A Boolean that indicates whether the CompanyTO is active or not.
 */
class CompanyTOTest {

    @Test
    void shouldCreateStatusWithGivenValues() {
        UUID id = UUID.randomUUID();
        CompanyTO companyTO = new CompanyTO(id, "name", "description", true);

        assertEquals(id, companyTO.id());
        assertEquals("name", companyTO.name());
        assertEquals("description", companyTO.description());
        assertTrue(companyTO.active());
    }

    @Test
    void shouldHandleNullValues() {
        CompanyTO companyTO = new CompanyTO(null, null, null, null);

        assertNull(companyTO.id());
        assertNull(companyTO.name());
        assertNull(companyTO.description());
        assertNull(companyTO.active());
    }

    @Test
    void shouldHandleEmptyStringValues() {
        CompanyTO companyTO = new CompanyTO(UUID.randomUUID(), "", "", true);

        assertEquals("", companyTO.name());
        assertEquals("", companyTO.description());
    }

    @Test
    void shouldHandleInactiveStatus() {
        CompanyTO companyTO = new CompanyTO(UUID.randomUUID(), "name", "description", false);

        assertFalse(companyTO.active());
    }
}
