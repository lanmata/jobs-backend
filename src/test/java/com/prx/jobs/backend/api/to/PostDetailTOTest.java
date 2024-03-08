package com.prx.jobs.backend.api.to;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class PostDetailTOTest {

    @Test
    void shouldCreatePostDetailTOWithValidData() {
        UUID id = UUID.randomUUID();
        String description = "Test Description";
        LocalDateTime datetime = LocalDateTime.now();
        BigDecimal mountRate = new BigDecimal("10.0");
        UUID postId = UUID.randomUUID();
        UUID statusId = UUID.randomUUID();

        PostDetailTO postDetailTO = new PostDetailTO(id, description, datetime, mountRate, postId, statusId);

        assertNotNull(postDetailTO);
        assertEquals(id, postDetailTO.id());
        assertEquals(description, postDetailTO.description());
        assertEquals(datetime, postDetailTO.datetime());
        assertEquals(mountRate, postDetailTO.mountRate());
        assertEquals(postId, postDetailTO.postId());
        assertEquals(statusId, postDetailTO.statusId());
    }

}
