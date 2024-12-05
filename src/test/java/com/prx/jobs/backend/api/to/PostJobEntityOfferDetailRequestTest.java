package com.prx.jobs.backend.api.to;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PostJobEntityOfferDetailRequestTest {

    @Test
    void shouldCreatePostJobOfferDetailRequestWithValidParameters() {
        String description = "Job description";
        LocalDateTime datetime = LocalDateTime.now();
        BigDecimal mountRate = new BigDecimal("100.00");
        UUID statusId = UUID.randomUUID();

        PostJobOfferDetailRequest request = new PostJobOfferDetailRequest(description, datetime, mountRate, statusId);

        assertNotNull(request);
        assertEquals(description, request.description());
        assertEquals(datetime, request.datetime());
        assertEquals(mountRate, request.mountRate());
        assertEquals(statusId, request.statusId());
    }
}
