package com.prx.jobs.backend.jpa.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class PostJobPKTest {

    @Test
    @DisplayName("PostJobPK equals and hashCode")
    void postJobPKEqualsAndHashCode() {
        UUID jobOfferId = UUID.randomUUID();
        UUID profileId = UUID.randomUUID();
        PostJobPK pk1 = new PostJobPK();
        pk1.setFkJobOffer(jobOfferId);
        pk1.setFkProfessionalProfile(profileId);

        PostJobPK pk2 = new PostJobPK();
        pk2.setFkJobOffer(jobOfferId);
        pk2.setFkProfessionalProfile(profileId);

        assertEquals(pk1, pk2);
        assertEquals(pk1.hashCode(), pk2.hashCode());
    }

    @Test
    @DisplayName("PostJobPK not equals different job offer id")
    void postJobPKNotEqualsDifferentJobOfferId() {
        UUID profileId = UUID.randomUUID();
        PostJobPK pk1 = new PostJobPK();
        pk1.setFkJobOffer(UUID.randomUUID());
        pk1.setFkProfessionalProfile(profileId);

        PostJobPK pk2 = new PostJobPK();
        pk2.setFkJobOffer(UUID.randomUUID());
        pk2.setFkProfessionalProfile(profileId);

        assertNotEquals(pk1, pk2);
    }

    @Test
    @DisplayName("PostJobPK not equals different professional profile id")
    void postJobPKNotEqualsDifferentProfessionalProfileId() {
        UUID jobOfferId = UUID.randomUUID();
        PostJobPK pk1 = new PostJobPK();
        pk1.setFkJobOffer(jobOfferId);
        pk1.setFkProfessionalProfile(UUID.randomUUID());

        PostJobPK pk2 = new PostJobPK();
        pk2.setFkJobOffer(jobOfferId);
        pk2.setFkProfessionalProfile(UUID.randomUUID());

        assertNotEquals(pk1, pk2);
    }

    @Test
    @DisplayName("PostJobPK getFkJobOffer")
    void postJobPKGetFkJobOffer() {
        UUID jobOfferId = UUID.randomUUID();
        PostJobPK pk = new PostJobPK();
        pk.setFkJobOffer(jobOfferId);

        assertEquals(jobOfferId, pk.getFkJobOffer());
    }

    @Test
    @DisplayName("PostJobPK getFkProfessionalProfile")
    void postJobPKGetFkProfessionalProfile() {
        UUID profileId = UUID.randomUUID();
        PostJobPK pk = new PostJobPK();
        pk.setFkProfessionalProfile(profileId);

        assertEquals(profileId, pk.getFkProfessionalProfile());
    }

    @Test
    @DisplayName("PostJobPK equals same object")
    void postJobPKEqualsSameObject() {
        UUID jobOfferId = UUID.randomUUID();
        UUID profileId = UUID.randomUUID();
        PostJobPK pk = new PostJobPK();
        pk.setFkJobOffer(jobOfferId);
        pk.setFkProfessionalProfile(profileId);

        assertEquals(pk, pk);
    }

    @Test
    @DisplayName("PostJobPK equals null")
    void postJobPKEqualsNull() {
        UUID jobOfferId = UUID.randomUUID();
        UUID profileId = UUID.randomUUID();
        PostJobPK pk = new PostJobPK();
        pk.setFkJobOffer(jobOfferId);
        pk.setFkProfessionalProfile(profileId);

        assertNotEquals(pk, null);
    }

    @Test
    @DisplayName("PostJobPK equals different class")
    void postJobPKEqualsDifferentClass() {
        UUID jobOfferId = UUID.randomUUID();
        UUID profileId = UUID.randomUUID();
        PostJobPK pk = new PostJobPK();
        pk.setFkJobOffer(jobOfferId);
        pk.setFkProfessionalProfile(profileId);

        assertNotEquals(pk, new Object());
    }

    @Test
    @DisplayName("PostJobPK equals different job offer id")
    void postJobPKEqualsDifferentJobOfferId() {
        UUID profileId = UUID.randomUUID();
        PostJobPK pk1 = new PostJobPK();
        pk1.setFkJobOffer(UUID.randomUUID());
        pk1.setFkProfessionalProfile(profileId);

        PostJobPK pk2 = new PostJobPK();
        pk2.setFkJobOffer(UUID.randomUUID());
        pk2.setFkProfessionalProfile(profileId);

        assertNotEquals(pk1, pk2);
    }

    @Test
    @DisplayName("PostJobPK equals different professional profile id")
    void postJobPKEqualsDifferentProfessionalProfileId() {
        UUID jobOfferId = UUID.randomUUID();
        PostJobPK pk1 = new PostJobPK();
        pk1.setFkJobOffer(jobOfferId);
        pk1.setFkProfessionalProfile(UUID.randomUUID());

        PostJobPK pk2 = new PostJobPK();
        pk2.setFkJobOffer(jobOfferId);
        pk2.setFkProfessionalProfile(UUID.randomUUID());

        assertNotEquals(pk1, pk2);
    }

    @Test
    @DisplayName("PostJobPK equals same values")
    void postJobPKEqualsSameValues() {
        UUID jobOfferId = UUID.randomUUID();
        UUID profileId = UUID.randomUUID();
        PostJobPK pk1 = new PostJobPK();
        pk1.setFkJobOffer(jobOfferId);
        pk1.setFkProfessionalProfile(profileId);

        PostJobPK pk2 = new PostJobPK();
        pk2.setFkJobOffer(jobOfferId);
        pk2.setFkProfessionalProfile(profileId);

        assertEquals(pk1, pk2);
    }

}
