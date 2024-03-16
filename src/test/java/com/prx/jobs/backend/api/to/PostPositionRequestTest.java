package com.prx.jobs.backend.api.to;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class PostPositionRequestTest {

    @Test
    void postPositionRequestCreation() {
        String name = "Position Name";
        String description = "Position Description";
        Boolean active = true;

        PostPositionRequest postPositionRequest = new PostPositionRequest(name, description, active);

        assertEquals(name, postPositionRequest.name());
        assertEquals(description, postPositionRequest.description());
        assertEquals(active, postPositionRequest.active());
    }

    @Test
    void postPositionRequestCreationWithNullValues() {
        PostPositionRequest postPositionRequest = new PostPositionRequest(null, null, null);

        assertNull(postPositionRequest.name());
        assertNull(postPositionRequest.description());
        assertNull(postPositionRequest.active());
    }
}
