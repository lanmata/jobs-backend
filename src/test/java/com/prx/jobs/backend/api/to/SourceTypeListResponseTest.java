package com.prx.jobs.backend.api.to;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SourceTypeListResponseTest {

    @Test
    void shouldReturnEmptyCollectionWhenNoStatusProvided() {
        SourceTypeListResponse response = new SourceTypeListResponse(Collections.emptyList());

        assertTrue(response.sourceTypeCollection().isEmpty());
    }

    @Test
    void shouldReturnSingleStatusWhenOneStatusProvided() {
        SourceTypeTO statusTO = new SourceTypeTO(UUID.randomUUID(), "name", "description", false);
        SourceTypeListResponse response = new SourceTypeListResponse(List.of(statusTO));

        assertEquals(1, response.sourceTypeCollection().size());
        assertTrue(response.sourceTypeCollection().contains(statusTO));
    }

    @Test
    void shouldReturnMultipleStatusWhenMultipleStatusProvided() {
        SourceTypeTO sourceTypeTO1 = new SourceTypeTO(UUID.randomUUID(), "name", "description", false);
        SourceTypeTO sourceType2 = new SourceTypeTO(UUID.randomUUID(), "name", "description", false);
        SourceTypeListResponse response = new SourceTypeListResponse(List.of(sourceTypeTO1, sourceType2));

        assertEquals(2, response.sourceTypeCollection().size());
        assertTrue(response.sourceTypeCollection().contains(sourceTypeTO1));
        assertTrue(response.sourceTypeCollection().contains(sourceType2));
    }

}
