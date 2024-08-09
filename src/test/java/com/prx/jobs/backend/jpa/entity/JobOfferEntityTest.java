package com.prx.jobs.backend.jpa.entity;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JobOfferEntityTest {

    @Test
    void settingAndGettingIdShouldWorkCorrectly() {
        JobOfferEntity jobOfferEntity = new JobOfferEntity();
        UUID id = UUID.randomUUID();
        jobOfferEntity.setId(id);
        assertEquals(id, jobOfferEntity.getId());
    }

    @Test
    void settingAndGettingTitleShouldWorkCorrectly() {
        JobOfferEntity jobOfferEntity = new JobOfferEntity();
        String title = "Test Title";
        jobOfferEntity.setTitle(title);
        assertEquals(title, jobOfferEntity.getTitle());
    }

    @Test
    void settingAndGettingDescriptionShouldWorkCorrectly() {
        JobOfferEntity jobOfferEntity = new JobOfferEntity();
        String description = "Test Description";
        jobOfferEntity.setDescription(description);
        assertEquals(description, jobOfferEntity.getDescription());
    }

    @Test
    void settingAndGettingReferenceShouldWorkCorrectly() {
        JobOfferEntity jobOfferEntity = new JobOfferEntity();
        String reference = "Test Reference";
        jobOfferEntity.setReference(reference);
        assertEquals(reference, jobOfferEntity.getReference());
    }

    @Test
    void settingAndGettingCompanyShouldWorkCorrectly() {
        JobOfferEntity jobOfferEntity = new JobOfferEntity();
        CompanyEntity company = new CompanyEntity();
        jobOfferEntity.setCompany(company);
        assertEquals(company, jobOfferEntity.getCompany());
    }

    @Test
    void settingAndGettingPositionShouldWorkCorrectly() {
        JobOfferEntity jobOfferEntity = new JobOfferEntity();
        PositionEntity position = new PositionEntity();
        jobOfferEntity.setPosition(position);
        assertEquals(position, jobOfferEntity.getPosition());
    }

    @Test
    void settingAndGettingTermShouldWorkCorrectly() {
        JobOfferEntity jobOfferEntity = new JobOfferEntity();
        TermEntity term = new TermEntity();
        jobOfferEntity.setTerm(term);
        assertEquals(term, jobOfferEntity.getTerm());
    }

    @Test
    void settingAndGettingModeShouldWorkCorrectly() {
        JobOfferEntity jobOfferEntity = new JobOfferEntity();
        ModeEntity mode = new ModeEntity();
        jobOfferEntity.setMode(mode);
        assertEquals(mode, jobOfferEntity.getMode());
    }

    @Test
    void settingAndGettingSourceShouldWorkCorrectly() {
        JobOfferEntity jobOfferEntity = new JobOfferEntity();
        SourceEntity source = new SourceEntity();
        jobOfferEntity.setSource(source);
        assertEquals(source, jobOfferEntity.getSource());
    }
}
