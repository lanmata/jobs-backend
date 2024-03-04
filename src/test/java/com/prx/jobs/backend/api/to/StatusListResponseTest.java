package com.prx.jobs.backend.api.to;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StatusListResponseTest {

    @Test
    void shouldReturnEmptyCollectionWhenNoStatusProvided() {
        StatusListResponse response = new StatusListResponse(Collections.emptyList());

        assertTrue(response.statusTOCollection().isEmpty());
    }

    @Test
    void shouldReturnSingleStatusWhenOneStatusProvided() {
        StatusTO statusTO = new StatusTO(UUID.randomUUID(), "name", "description", false);
        StatusListResponse response = new StatusListResponse(List.of(statusTO));

        assertEquals(1, response.statusTOCollection().size());
        assertTrue(response.statusTOCollection().contains(statusTO));
    }

    @Test
    void shouldReturnMultipleStatusWhenMultipleStatusProvided() {
        StatusTO statusTO1 = new StatusTO(UUID.randomUUID(), "name", "description", false);
        StatusTO statusTO2 = new StatusTO(UUID.randomUUID(), "name", "description", false);
        StatusListResponse response = new StatusListResponse(List.of(statusTO1, statusTO2));

        assertEquals(2, response.statusTOCollection().size());
        assertTrue(response.statusTOCollection().contains(statusTO1));
        assertTrue(response.statusTOCollection().contains(statusTO2));
    }

}
