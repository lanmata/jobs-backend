package com.prx.jobs.backend.jpa.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class SourceTypeEntityTest {
    private SourceTypeEntity sourceTypeEntity;

    @BeforeEach
    void setUp() {
        sourceTypeEntity = new SourceTypeEntity();
        sourceTypeEntity.setId(UUID.randomUUID());
        sourceTypeEntity.setName("Test Name");
        sourceTypeEntity.setDescription("Test Description");
        sourceTypeEntity.setActive(true);
    }

    @Test
    void testGetId() {
        assertNotNull(sourceTypeEntity.getId());
    }

    @Test
    void testGetName() {
        assertEquals("Test Name", sourceTypeEntity.getName());
    }

    @Test
    void testGetDescription() {
        assertEquals("Test Description", sourceTypeEntity.getDescription());
    }

    @Test
    void testGetActive() {
        assertTrue(sourceTypeEntity.getActive());
    }

    @Test
    void testSetName() {
        sourceTypeEntity.setName("New Test Name");
        assertEquals("New Test Name", sourceTypeEntity.getName());
    }

    @Test
    void testSetDescription() {
        sourceTypeEntity.setDescription("New Test Description");
        assertEquals("New Test Description", sourceTypeEntity.getDescription());
    }

    @Test
    void testSetActive() {
        sourceTypeEntity.setActive(false);
        assertFalse(sourceTypeEntity.getActive());
    }
}
