package com.prx.jobs.backend.jpa.entity;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ModeEntityTest {

    @Test
    void shouldReturnIdWhenGetIdIsCalled() {
        ModeEntity modeEntity = new ModeEntity();
        UUID expectedId = UUID.randomUUID();
        modeEntity.setId(expectedId);

        UUID actualId = modeEntity.getId();

        assertEquals(expectedId, actualId);
    }

    @Test
    void shouldReturnNameWhenGetNameIsCalled() {
        ModeEntity modeEntity = new ModeEntity();
        String expectedName = "Test Name";
        modeEntity.setName(expectedName);

        String actualName = modeEntity.getName();

        assertEquals(expectedName, actualName);
    }

    @Test
    void shouldReturnDescriptionWhenGetDescriptionIsCalled() {
        ModeEntity modeEntity = new ModeEntity();
        String expectedDescription = "Test Description";
        modeEntity.setDescription(expectedDescription);

        String actualDescription = modeEntity.getDescription();

        assertEquals(expectedDescription, actualDescription);
    }

    @Test
    void shouldReturnActiveWhenGetActiveIsCalled() {
        ModeEntity modeEntity = new ModeEntity();
        Boolean expectedActive = true;
        modeEntity.setActive(expectedActive);

        Boolean actualActive = modeEntity.getActive();

        assertEquals(expectedActive, actualActive);
    }

    @Test
    void shouldHandleNullValues() {
        ModeEntity modeEntity = new ModeEntity();
        modeEntity.setId(null);
        modeEntity.setName(null);
        modeEntity.setDescription(null);
        modeEntity.setActive(null);

        assertNull(modeEntity.getId());
        assertNull(modeEntity.getName());
        assertNull(modeEntity.getDescription());
        assertNull(modeEntity.getActive());
    }
}
