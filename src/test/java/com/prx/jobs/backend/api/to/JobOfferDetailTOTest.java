package com.prx.jobs.backend.api.to;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class JobOfferDetailTOTest {

    @Test
    void shouldCreatePostDetailTOWithValidData() {
        UUID id = UUID.randomUUID();
        String description = "Test Description";
        LocalDateTime datetime = LocalDateTime.now();
        BigDecimal mountRate = new BigDecimal("10.0");
        UUID postId = UUID.randomUUID();
        UUID statusId = UUID.randomUUID();

        JobOfferDetailTO jobOfferDetailTO = new JobOfferDetailTO(id, description, datetime, mountRate, postId, statusId);

        assertNotNull(jobOfferDetailTO);
        assertEquals(id, jobOfferDetailTO.id());
        assertEquals(description, jobOfferDetailTO.description());
        assertEquals(datetime, jobOfferDetailTO.datetime());
        assertEquals(mountRate, jobOfferDetailTO.mountRate());
        assertEquals(postId, jobOfferDetailTO.jobOfferId());
        assertEquals(statusId, jobOfferDetailTO.statusId());
    }

}
