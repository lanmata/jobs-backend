package com.prx.jobs.backend.jpa.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class SourceEntityTest {

    private SourceEntity sourceEntity;

    @BeforeEach
    void setUp() {
        sourceEntity = new SourceEntity();
    }

    @Test
    void shouldSetAndGetId() {
        UUID id = UUID.randomUUID();
        sourceEntity.setId(id);
        assertEquals(id, sourceEntity.getId());
    }

    @Test
    void shouldSetAndGetName() {
        String name = "Test Name";
        sourceEntity.setName(name);
        assertEquals(name, sourceEntity.getName());
    }

    @Test
    void shouldSetAndGetDescription() {
        String description = "Test Description";
        sourceEntity.setDescription(description);
        assertEquals(description, sourceEntity.getDescription());
    }

    @Test
    void shouldSetAndGetActive() {
        sourceEntity.setActive(true);
        assertTrue(sourceEntity.getActive());
    }

    @Test
    void shouldSetAndGetSourceType() {
        SourceTypeEntity sourceType = new SourceTypeEntity();
        sourceEntity.setSourceType(sourceType);
        assertEquals(sourceType, sourceEntity.getSourceType());
    }

    @Test
    void shouldHandleNullSourceType() {
        sourceEntity.setSourceType(null);
        assertNull(sourceEntity.getSourceType());
    }
}
