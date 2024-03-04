package com.prx.jobs.backend.jpa.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class PositionEntityTest {
    private PositionEntity positionEntity;

    @BeforeEach
    void setUp() {
        positionEntity = new PositionEntity();
    }

    @Test
    void settingAndGettingId() {
        UUID id = UUID.randomUUID();
        positionEntity.setId(id);
        assertEquals(id, positionEntity.getId());
    }

    @Test
    void settingAndGettingName() {
        String name = "Software Engineer";
        positionEntity.setName(name);
        assertEquals(name, positionEntity.getName());
    }

    @Test
    void settingAndGettingDescription() {
        String description = "Responsible for developing software solutions.";
        positionEntity.setDescription(description);
        assertEquals(description, positionEntity.getDescription());
    }

    @Test
    void settingAndGettingActive() {
        positionEntity.setActive(true);
        assertTrue(positionEntity.getActive());
    }

    @Test
    void settingAndGettingActiveWhenNull() {
        positionEntity.setActive(null);
        assertNull(positionEntity.getActive());
    }

    @Test
    void settingAndGettingNameWithMaxLength() {
        String name = "a".repeat(60);
        positionEntity.setName(name);
        assertEquals(name, positionEntity.getName());
    }

    @Test
    void settingAndGettingDescriptionWithMaxLength() {
        String description = "a".repeat(255);
        positionEntity.setDescription(description);
        assertEquals(description, positionEntity.getDescription());
    }
}
