package com.prx.jobs.backend.jpa.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class PostJobEntityTest {

    @Test
    @DisplayName("PostJobEntity equals and hashCode")
    void postJobEntityEqualsAndHashCode() {
        PostJobPK id = new PostJobPK();
        id.setFkJobOffer(UUID.randomUUID());
        id.setFkProfessionalProfile(UUID.randomUUID());
        JobOfferEntity jobOffer = new JobOfferEntity();
        ProfessionalProfileEntity profile = new ProfessionalProfileEntity();
        PostJobEntity entity1 = new PostJobEntity();
        entity1.setId(id);
        entity1.setFkJobOffer(jobOffer);
        entity1.setFkProfessionalProfile(profile);
        entity1.setStatus("Active");
        entity1.setLastUpdate(LocalDate.of(2023, 10, 1));

        PostJobEntity entity2 = new PostJobEntity();
        entity2.setId(id);
        entity2.setFkJobOffer(jobOffer);
        entity2.setFkProfessionalProfile(profile);
        entity2.setStatus("Active");
        entity2.setLastUpdate(LocalDate.of(2023, 10, 1));

        assertEquals(entity1, entity2);
        assertEquals(entity1.hashCode(), entity2.hashCode());
    }

    @Test
    @DisplayName("PostJobEntity not equals different id")
    void postJobEntityNotEqualsDifferentId() {
        JobOfferEntity jobOffer = new JobOfferEntity();
        ProfessionalProfileEntity profile = new ProfessionalProfileEntity();
        PostJobEntity entity1 = new PostJobEntity();
        PostJobPK id = new PostJobPK();
        id.setFkJobOffer(UUID.randomUUID());
        id.setFkProfessionalProfile(UUID.randomUUID());
        entity1.setId(id);
        entity1.setFkJobOffer(jobOffer);
        entity1.setFkProfessionalProfile(profile);
        entity1.setStatus("Active");
        entity1.setLastUpdate(LocalDate.of(2023, 10, 1));

        PostJobEntity entity2 = new PostJobEntity();
        PostJobPK id2 = new PostJobPK();
        id2.setFkJobOffer(UUID.randomUUID());
        id2.setFkProfessionalProfile(UUID.randomUUID());
        entity2.setId(id2);
        entity2.setFkJobOffer(jobOffer);
        entity2.setFkProfessionalProfile(profile);
        entity2.setStatus("Active");
        entity2.setLastUpdate(LocalDate.of(2023, 10, 1));

        assertNotEquals(entity1, entity2);
    }

    @Test
    @DisplayName("PostJobEntity not equals different status")
    void postJobEntityNotEqualsDifferentStatus() {
        PostJobPK id = new PostJobPK();
        id.setFkJobOffer(UUID.randomUUID());
        id.setFkProfessionalProfile(UUID.randomUUID());
        JobOfferEntity jobOffer = new JobOfferEntity();
        ProfessionalProfileEntity profile = new ProfessionalProfileEntity();
        PostJobEntity entity1 = new PostJobEntity();
        entity1.setId(id);
        entity1.setFkJobOffer(jobOffer);
        entity1.setFkProfessionalProfile(profile);
        entity1.setStatus("Active");
        entity1.setLastUpdate(LocalDate.of(2023, 10, 1));

        PostJobEntity entity2 = new PostJobEntity();
        entity2.setId(id);
        entity2.setFkJobOffer(jobOffer);
        entity2.setFkProfessionalProfile(profile);
        entity2.setStatus("Inactive");
        entity2.setLastUpdate(LocalDate.of(2023, 10, 1));

        assertNotEquals(entity1, entity2);
    }

    @Test
    @DisplayName("PostJobEntity toString")
    void postJobEntityToString() {
        PostJobPK id = new PostJobPK();
        id.setFkJobOffer(UUID.randomUUID());
        id.setFkProfessionalProfile(UUID.randomUUID());
        JobOfferEntity jobOffer = new JobOfferEntity();
        ProfessionalProfileEntity profile = new ProfessionalProfileEntity();
        PostJobEntity entity = new PostJobEntity();
        entity.setId(id);
        entity.setFkJobOffer(jobOffer);
        entity.setFkProfessionalProfile(profile);
        entity.setStatus("Active");
        entity.setLastUpdate(LocalDate.of(2023, 10, 1));

        String expected = "PostJobEntity{id=" + id + ", fkJobOffer=" + jobOffer + ", fkProfessionalProfile=" + profile + ", status='Active', lastUpdate=2023-10-01}";
        assertEquals(expected, entity.toString());
    }
}
