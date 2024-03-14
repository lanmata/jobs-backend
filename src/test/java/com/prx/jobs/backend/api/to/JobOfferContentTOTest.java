package com.prx.jobs.backend.api.to;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class JobOfferContentTOTest {

    @Test
    void jobOfferContentTOCreation() {
        UUID id = UUID.randomUUID();
        BigDecimal mount = new BigDecimal("1000.00");
        LocalDateTime createdDate = LocalDateTime.now();
        LocalDateTime lastModifiedDate = LocalDateTime.now();
        String status = "active";
        String company = "Company";
        String position = "Position";
        String term = "Term";
        String mode = "Mode";
        String source = "Source";

        JobOfferContentTO jobOfferContentTO = new JobOfferContentTO(id, mount, createdDate,
                lastModifiedDate, status, company, position, term, mode, source);

        assertEquals(id, jobOfferContentTO.id());
        assertEquals(mount, jobOfferContentTO.mount());
        assertEquals(createdDate, jobOfferContentTO.createdDate());
        assertEquals(lastModifiedDate, jobOfferContentTO.lastModifiedDate());
        assertEquals(status, jobOfferContentTO.status());
        assertEquals(company, jobOfferContentTO.company());
        assertEquals(position, jobOfferContentTO.position());
        assertEquals(term, jobOfferContentTO.term());
        assertEquals(mode, jobOfferContentTO.mode());
        assertEquals(source, jobOfferContentTO.source());
    }

    @Test
    void jobOfferContentTOCreationWithNullValues() {
        JobOfferContentTO jobOfferContentTO = new JobOfferContentTO(null, null, null, null, null, null, null, null, null, null);

        assertNull(jobOfferContentTO.id());
        assertNull(jobOfferContentTO.mount());
        assertNull(jobOfferContentTO.createdDate());
        assertNull(jobOfferContentTO.lastModifiedDate());
        assertNull(jobOfferContentTO.status());
        assertNull(jobOfferContentTO.company());
        assertNull(jobOfferContentTO.position());
        assertNull(jobOfferContentTO.term());
        assertNull(jobOfferContentTO.mode());
        assertNull(jobOfferContentTO.source());
    }
}
