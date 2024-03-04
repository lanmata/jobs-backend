package com.prx.jobs.backend.jpa.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

class PostDetailEntityTest {

    @Mock
    private PostEntity postEntity;

    @Mock
    private StatusEntity statusEntity;

    private PostDetailEntity postDetailEntity;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        postDetailEntity = new PostDetailEntity();
    }

    @Test
    void setsAndGetsId() {
        UUID id = UUID.randomUUID();
        postDetailEntity.setId(id);
        assertEquals(id, postDetailEntity.getId());
    }

    @Test
    void setsAndGetsDescription() {
        String description = "Test Description";
        postDetailEntity.setDescription(description);
        assertEquals(description, postDetailEntity.getDescription());
    }

    @Test
    void setsAndGetsDatetime() {
        Instant datetime = Instant.now();
        postDetailEntity.setDatetime(datetime);
        assertEquals(datetime, postDetailEntity.getDatetime());
    }

    @Test
    void setsAndGetsMountRate() {
        BigDecimal mountRate = new BigDecimal("10.00");
        postDetailEntity.setMountRate(mountRate);
        assertEquals(mountRate, postDetailEntity.getMountRate());
    }

    @Test
    void setsAndGetsPost() {
        when(postEntity.getId()).thenReturn(UUID.randomUUID());
        postDetailEntity.setPost(postEntity);
        assertNotNull(postDetailEntity.getPost());
        assertEquals(postEntity.getId(), postDetailEntity.getPost().getId());
    }

    @Test
    void setsAndGetsStatus() {
        when(statusEntity.getId()).thenReturn(UUID.randomUUID());
        postDetailEntity.setStatus(statusEntity);
        assertNotNull(postDetailEntity.getStatus());
        assertEquals(statusEntity.getId(), postDetailEntity.getStatus().getId());
    }
}
