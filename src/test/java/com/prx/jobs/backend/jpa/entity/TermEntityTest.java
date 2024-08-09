package com.prx.jobs.backend.jpa.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TermEntityTest {
    private TermEntity termEntity;

    @BeforeEach
    void setUp() {
        termEntity = new TermEntity();
    }

    @Test
    void getId() {
        UUID id = UUID.randomUUID();
        termEntity.setId(id);
        assertEquals(id, termEntity.getId());
    }

    @Test
    void setId() {
        UUID id = UUID.randomUUID();
        termEntity.setId(id);
        assertEquals(id, termEntity.getId());
    }

    @Test
    void getName() {
        String name = "name";
        termEntity.setName(name);
        assertEquals(name, termEntity.getName());
    }

    @Test
    void setName() {
        String name = "name";
        termEntity.setName(name);
        assertEquals(name, termEntity.getName());
    }

    @Test
    void getDescription() {
        String description = "description";
        termEntity.setDescription(description);
        assertEquals(description, termEntity.getDescription());
    }

    @Test
    void setDescription() {
        String description = "description";
        termEntity.setDescription(description);
        assertEquals(description, termEntity.getDescription());
    }

    @Test
    void getActive() {
        Boolean active = true;
        termEntity.setActive(active);
        assertEquals(active, termEntity.getActive());
    }

    @Test
    void setActive() {
        Boolean active = true;
        termEntity.setActive(active);
        assertEquals(active, termEntity.getActive());
    }
}
