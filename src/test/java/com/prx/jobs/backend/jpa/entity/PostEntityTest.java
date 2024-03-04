package com.prx.jobs.backend.jpa.entity;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.UUID;

class PostEntityTest {

    @Test
    void settingAndGettingIdShouldWorkCorrectly() {
        PostEntity postEntity = new PostEntity();
        UUID id = UUID.randomUUID();
        postEntity.setId(id);
        assertEquals(id, postEntity.getId());
    }

    @Test
    void settingAndGettingTitleShouldWorkCorrectly() {
        PostEntity postEntity = new PostEntity();
        String title = "Test Title";
        postEntity.setTitle(title);
        assertEquals(title, postEntity.getTitle());
    }

    @Test
    void settingAndGettingDescriptionShouldWorkCorrectly() {
        PostEntity postEntity = new PostEntity();
        String description = "Test Description";
        postEntity.setDescription(description);
        assertEquals(description, postEntity.getDescription());
    }

    @Test
    void settingAndGettingReferenceShouldWorkCorrectly() {
        PostEntity postEntity = new PostEntity();
        String reference = "Test Reference";
        postEntity.setReference(reference);
        assertEquals(reference, postEntity.getReference());
    }

    @Test
    void settingAndGettingCompanyShouldWorkCorrectly() {
        PostEntity postEntity = new PostEntity();
        CompanyEntity company = new CompanyEntity();
        postEntity.setCompany(company);
        assertEquals(company, postEntity.getCompany());
    }

    @Test
    void settingAndGettingPositionShouldWorkCorrectly() {
        PostEntity postEntity = new PostEntity();
        PositionEntity position = new PositionEntity();
        postEntity.setPosition(position);
        assertEquals(position, postEntity.getPosition());
    }

    @Test
    void settingAndGettingTermShouldWorkCorrectly() {
        PostEntity postEntity = new PostEntity();
        TermEntity term = new TermEntity();
        postEntity.setTerm(term);
        assertEquals(term, postEntity.getTerm());
    }

    @Test
    void settingAndGettingModeShouldWorkCorrectly() {
        PostEntity postEntity = new PostEntity();
        ModeEntity mode = new ModeEntity();
        postEntity.setMode(mode);
        assertEquals(mode, postEntity.getMode());
    }

    @Test
    void settingAndGettingSourceShouldWorkCorrectly() {
        PostEntity postEntity = new PostEntity();
        SourceEntity source = new SourceEntity();
        postEntity.setSource(source);
        assertEquals(source, postEntity.getSource());
    }
}
