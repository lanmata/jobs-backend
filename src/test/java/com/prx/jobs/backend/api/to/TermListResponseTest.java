package com.prx.jobs.backend.api.to;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TermListResponseTest {

    @Test
    void shouldReturnEmptyCollectionWhenNoTermProvided() {
        TermListResponse response = new TermListResponse(Collections.emptyList());

        assertTrue(response.list().isEmpty());
    }

    @Test
    void shouldReturnSingleTermWhenOneTermProvided() {
        TermTO termTO = new TermTO(UUID.randomUUID(), "name", "description", false);
        TermListResponse response = new TermListResponse(List.of(termTO));

        assertEquals(1, response.list().size());
        assertTrue(response.list().contains(termTO));
    }

    @Test
    void shouldReturnMultipleTermsWhenMultipleTermsProvided() {
        TermTO termTO1 = new TermTO(UUID.randomUUID(), "name", "description", false);
        TermTO termTO2 = new TermTO(UUID.randomUUID(), "name", "description", false);
        TermListResponse response = new TermListResponse(List.of(termTO1, termTO2));

        assertEquals(2, response.list().size());
        assertTrue(response.list().contains(termTO1));
        assertTrue(response.list().contains(termTO2));
    }
}
