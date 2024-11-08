package com.prx.jobs.backend.api.to;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SourceListResponseTest {

    @Test
    void shouldReturnEmptyCollectionWhenNoSourceProvided() {
        SourceListResponse response = new SourceListResponse(Collections.emptyList());

        assertTrue(response.list().isEmpty());
    }

    @Test
    void shouldReturnSingleSourceWhenOneSourceProvided() {
        SourceTO sourceTO = new SourceTO(UUID.randomUUID(), "name", "description", false, null);
        SourceListResponse response = new SourceListResponse(List.of(sourceTO));

        assertEquals(1, response.list().size());
        assertTrue(response.list().contains(sourceTO));
    }

    @Test
    void shouldReturnMultipleSourceWhenMultipleSourceProvided() {
        SourceTO sourceTO1 = new SourceTO(UUID.randomUUID(), "name", "description", false, null);
        SourceTO source2 = new SourceTO(UUID.randomUUID(), "name", "description", false, null);
        SourceListResponse response = new SourceListResponse(List.of(sourceTO1, source2));

        assertEquals(2, response.list().size());
        assertTrue(response.list().contains(sourceTO1));
        assertTrue(response.list().contains(source2));
    }

}
