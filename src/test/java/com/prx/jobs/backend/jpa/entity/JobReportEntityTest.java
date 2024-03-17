package com.prx.jobs.backend.jpa.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JobReportEntityTest {

    @Test
    @DisplayName("Should correctly set and get id")
    void id() {
        JobReportEntity jobReportEntity = new JobReportEntity();
        UUID id = UUID.randomUUID();
        jobReportEntity.setId(id);
        assertEquals(id, jobReportEntity.getId());
    }

    @Test
    @DisplayName("Should correctly set and get mount")
    void mount() {
        JobReportEntity jobReportEntity = new JobReportEntity();
        BigDecimal mount = new BigDecimal("123.45");
        jobReportEntity.setMount(mount);
        assertEquals(mount, jobReportEntity.getMount());
    }

    @Test
    @DisplayName("Should correctly set and get createdDate")
    void createdDate() {
        JobReportEntity jobReportEntity = new JobReportEntity();
        LocalDateTime createdDate = LocalDateTime.now();
        jobReportEntity.setCreatedDate(createdDate);
        assertEquals(createdDate, jobReportEntity.getCreatedDate());
    }

    @Test
    @DisplayName("Should correctly set and get lastModifiedDate")
    void lastModifiedDate() {
        JobReportEntity jobReportEntity = new JobReportEntity();
        LocalDateTime lastModifiedDate = LocalDateTime.now();
        jobReportEntity.setLastModifiedDate(lastModifiedDate);
        assertEquals(lastModifiedDate, jobReportEntity.getLastModifiedDate());
    }

    @Test
    @DisplayName("Should correctly set and get status")
    void status() {
        JobReportEntity jobReportEntity = new JobReportEntity();
        String status = "status";
        jobReportEntity.setStatus(status);
        assertEquals(status, jobReportEntity.getStatus());
    }

    @Test
    @DisplayName("Should correctly set and get company")
    void company() {
        JobReportEntity jobReportEntity = new JobReportEntity();
        String company = "company";
        jobReportEntity.setCompany(company);
        assertEquals(company, jobReportEntity.getCompany());
    }

    @Test
    @DisplayName("Should correctly set and get position")
    void position() {
        JobReportEntity jobReportEntity = new JobReportEntity();
        String position = "position";
        jobReportEntity.setPosition(position);
        assertEquals(position, jobReportEntity.getPosition());
    }

    @Test
    @DisplayName("Should correctly set and get term")
    void term() {
        JobReportEntity jobReportEntity = new JobReportEntity();
        String term = "term";
        jobReportEntity.setTerm(term);
        assertEquals(term, jobReportEntity.getTerm());
    }

    @Test
    @DisplayName("Should correctly set and get mode")
    void mode() {
        JobReportEntity jobReportEntity = new JobReportEntity();
        String mode = "mode";
        jobReportEntity.setMode(mode);
        assertEquals(mode, jobReportEntity.getMode());
    }

    @Test
    @DisplayName("Should correctly set and get source")
    void source() {
        JobReportEntity jobReportEntity = new JobReportEntity();
        String source = "source";
        jobReportEntity.setSource(source);
        assertEquals(source, jobReportEntity.getSource());
    }
}
