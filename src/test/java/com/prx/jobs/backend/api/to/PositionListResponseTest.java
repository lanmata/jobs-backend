package com.prx.jobs.backend.api.to;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PositionListResponseTest {

    @Test
    void shouldReturnEmptyCollectionWhenNoModesProvided() {
        PositionListResponse response = new PositionListResponse(Collections.emptyList());

        assertTrue(response.positionTOCollection().isEmpty());
    }

    @Test
    void shouldReturnSingleModeWhenOneModeProvided() {
        PositionTO positionTO = new PositionTO(UUID.randomUUID(), "name", "description", false);
        PositionListResponse response = new PositionListResponse(List.of(positionTO));

        assertEquals(1, response.positionTOCollection().size());
        assertTrue(response.positionTOCollection().contains(positionTO));
    }

    @Test
    void shouldReturnMultipleModesWhenMultipleModesProvided() {
        PositionTO position1 = new PositionTO(UUID.randomUUID(), "name", "description", false);
        PositionTO position2 = new PositionTO(UUID.randomUUID(), "name", "description", false);
        PositionListResponse response = new PositionListResponse(List.of(position1, position2));

        assertEquals(2, response.positionTOCollection().size());
        assertTrue(response.positionTOCollection().contains(position1));
        assertTrue(response.positionTOCollection().contains(position2));
    }
}
