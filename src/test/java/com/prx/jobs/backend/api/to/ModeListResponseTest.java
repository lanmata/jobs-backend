package com.prx.jobs.backend.api.to;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ModeListResponseTest {

    @Test
    void shouldReturnEmptyCollectionWhenNoModesProvided() {
        ModeListResponse response = new ModeListResponse(Collections.emptyList());

        assertTrue(response.list().isEmpty());
    }

    @Test
    void shouldReturnSingleModeWhenOneModeProvided() {
        ModeTO modeTO = new ModeTO(UUID.randomUUID(), "name", "description", false);
        ModeListResponse response = new ModeListResponse(List.of(modeTO));

        assertEquals(1, response.list().size());
        assertTrue(response.list().contains(modeTO));
    }

    @Test
    void shouldReturnMultipleModesWhenMultipleModesProvided() {
        ModeTO mode1 = new ModeTO(UUID.randomUUID(), "name", "description", false);
        ModeTO mode2 = new ModeTO(UUID.randomUUID(), "name", "description", false);
        ModeListResponse response = new ModeListResponse(List.of(mode1, mode2));

        assertEquals(2, response.list().size());
        assertTrue(response.list().contains(mode1));
        assertTrue(response.list().contains(mode2));
    }
}
