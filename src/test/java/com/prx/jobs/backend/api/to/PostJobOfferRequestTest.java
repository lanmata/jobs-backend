package com.prx.jobs.backend.api.to;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PostJobOfferRequestTest {

    @Test
    void shouldCreatePostJobOfferRequestWithValidData() {
        // Given
        String title = "Software Engineer";
        String description = "Develop and maintain software applications";
        String reference = "REF123";
        UUID companyId = UUID.randomUUID();
        UUID positionId = UUID.randomUUID();
        UUID termId = UUID.randomUUID();
        UUID modeId = UUID.randomUUID();
        UUID sourceId = UUID.randomUUID();
        UUID statusId = UUID.randomUUID();
        BigDecimal mountRate = new BigDecimal("1000.00");
        LocalDateTime dateTime = LocalDateTime.now();

        // When
        PostJobOfferRequest request = new PostJobOfferRequest(title, description, reference, companyId, positionId, termId, modeId, sourceId, statusId, mountRate, dateTime);

        // Then
        assertEquals(title, request.title());
        assertEquals(description, request.description());
        assertEquals(reference, request.reference());
        assertEquals(companyId, request.companyId());
        assertEquals(positionId, request.positionId());
        assertEquals(termId, request.termId());
        assertEquals(modeId, request.modeId());
        assertEquals(sourceId, request.sourceId());
        assertEquals(statusId, request.statusId());
        assertEquals(mountRate, request.mountRate());
        assertEquals(dateTime, request.dateTime());
    }

}
