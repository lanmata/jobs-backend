package com.prx.jobs.backend.jpa.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

class JobOfferDetailEntityTest {

    @Mock
    private JobOfferEntity jobOfferEntity;

    @Mock
    private StatusEntity statusEntity;

    private JobOfferDetailEntity jobOfferDetailEntity;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        jobOfferDetailEntity = new JobOfferDetailEntity();
    }

    @Test
    void setsAndGetsId() {
        UUID id = UUID.randomUUID();
        jobOfferDetailEntity.setId(id);
        assertEquals(id, jobOfferDetailEntity.getId());
    }

    @Test
    void setsAndGetsDescription() {
        String description = "Test Description";
        jobOfferDetailEntity.setDescription(description);
        assertEquals(description, jobOfferDetailEntity.getDescription());
    }

    @Test
    void setsAndGetsDatetime() {
        LocalDateTime datetime = LocalDateTime.now();
        jobOfferDetailEntity.setDatetime(datetime);
        assertEquals(datetime, jobOfferDetailEntity.getDatetime());
    }

    @Test
    void setsAndGetsMountRate() {
        BigDecimal mountRate = new BigDecimal("10.00");
        jobOfferDetailEntity.setMountRate(mountRate);
        assertEquals(mountRate, jobOfferDetailEntity.getMountRate());
    }

    @Test
    void setsAndGetsPost() {
        when(jobOfferEntity.getId()).thenReturn(UUID.randomUUID());
        jobOfferDetailEntity.setOfferEntity(jobOfferEntity);
        assertNotNull(jobOfferDetailEntity.getOfferEntity());
        assertEquals(jobOfferEntity.getId(), jobOfferDetailEntity.getOfferEntity().getId());
    }

    @Test
    void setsAndGetsStatus() {
        when(statusEntity.getId()).thenReturn(UUID.randomUUID());
        jobOfferDetailEntity.setStatus(statusEntity);
        assertNotNull(jobOfferDetailEntity.getStatus());
        assertEquals(statusEntity.getId(), jobOfferDetailEntity.getStatus().getId());
    }
}
