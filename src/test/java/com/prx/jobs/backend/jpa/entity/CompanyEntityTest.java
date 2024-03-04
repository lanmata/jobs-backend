package com.prx.jobs.backend.jpa.entity;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class CompanyEntityTest {

    @Test
    void shouldSetAndGetId() {
        CompanyEntity companyEntity = new CompanyEntity();
        UUID id = UUID.randomUUID();
        companyEntity.setId(id);
        assertEquals(id, companyEntity.getId());
    }

    @Test
    void shouldSetAndGetName() {
        CompanyEntity companyEntity = new CompanyEntity();
        String name = "Test Company";
        companyEntity.setName(name);
        assertEquals(name, companyEntity.getName());
    }

    @Test
    void shouldSetAndGetDescription() {
        CompanyEntity companyEntity = new CompanyEntity();
        String description = "This is a test company";
        companyEntity.setDescription(description);
        assertEquals(description, companyEntity.getDescription());
    }

    @Test
    void shouldSetAndGetActive() {
        CompanyEntity companyEntity = new CompanyEntity();
        companyEntity.setActive(true);
        assertTrue(companyEntity.getActive());
    }

    @Test
    void shouldHandleNullActive() {
        CompanyEntity companyEntity = new CompanyEntity();
        companyEntity.setActive(null);
        assertNull(companyEntity.getActive());
    }

    @Test
    void shouldHandleNullId() {
        CompanyEntity companyEntity = new CompanyEntity();
        companyEntity.setId(null);
        assertNull(companyEntity.getId());
    }

    @Test
    void shouldHandleNullName() {
        CompanyEntity companyEntity = new CompanyEntity();
        companyEntity.setName(null);
        assertNull(companyEntity.getName());
    }

    @Test
    void shouldHandleNullDescription() {
        CompanyEntity companyEntity = new CompanyEntity();
        companyEntity.setDescription(null);
        assertNull(companyEntity.getDescription());
    }
}
