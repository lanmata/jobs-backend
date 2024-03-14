package com.prx.jobs.backend.api.to;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class PutJobOfferRequestTest {

    @Test
    @DisplayName("Should create PutJobOfferRequest with all fields set")
    void shouldCreatePutJobOfferRequestWithAllFieldsSet() {
        PutJobOfferRequest request = new PutJobOfferRequest(UUID.randomUUID(), UUID.randomUUID(), UUID.randomUUID(),
                UUID.randomUUID(), UUID.randomUUID(), BigDecimal.TEN, "description", LocalDateTime.now());

        assertNotNull(request.companyId());
        assertNotNull(request.modeId());
        assertNotNull(request.termId());
        assertNotNull(request.sourceId());
        assertNotNull(request.statusId());
        assertNotNull(request.mountRate());
        assertNotNull(request.description());
        assertNotNull(request.createdDateTime());
    }

    @Test
    @DisplayName("Should create PutJobOfferRequest with null fields")
    void shouldCreatePutJobOfferRequestWithNullFields() {
        PutJobOfferRequest request = new PutJobOfferRequest(null, null, null, null, null, null, null, null);

        assertNull(request.companyId());
        assertNull(request.modeId());
        assertNull(request.termId());
        assertNull(request.sourceId());
        assertNull(request.statusId());
        assertNull(request.mountRate());
        assertNull(request.description());
        assertNull(request.createdDateTime());
    }
}
