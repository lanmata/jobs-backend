package com.prx.jobs.backend.jpa.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class StatusEntityTest {
    private StatusEntity statusEntity;

    @BeforeEach
    void setUp() {
        statusEntity = new StatusEntity();
    }

    @Test
    void settingAndGettingId() {
        UUID id = UUID.randomUUID();
        statusEntity.setId(id);
        assertEquals(id, statusEntity.getId());
    }

    @Test
    void settingAndGettingName() {
        String name = "Test Name";
        statusEntity.setName(name);
        assertEquals(name, statusEntity.getName());
    }

    @Test
    void settingAndGettingDescription() {
        String description = "Test Description";
        statusEntity.setDescription(description);
        assertEquals(description, statusEntity.getDescription());
    }

    @Test
    void settingAndGettingActive() {
        statusEntity.setActive(true);
        assertTrue(statusEntity.getActive());

        statusEntity.setActive(false);
        assertFalse(statusEntity.getActive());
    }

    @Test
    void settingAndGettingNameWithMaxLength() {
        String name = "A".repeat(60);
        statusEntity.setName(name);
        assertEquals(name, statusEntity.getName());
    }

    @Test
    void settingAndGettingDescriptionWithMaxLength() {
        String description = "A".repeat(255);
        statusEntity.setDescription(description);
        assertEquals(description, statusEntity.getDescription());
    }
}
