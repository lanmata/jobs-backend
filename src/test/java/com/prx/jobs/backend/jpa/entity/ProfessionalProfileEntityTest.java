package com.prx.jobs.backend.jpa.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class ProfessionalProfileEntityTest {

    @Test
    @DisplayName("ProfessionalProfileEntity equals and hashCode")
    void professionalProfileEntityEqualsAndHashCode() {
        UUID id = UUID.randomUUID();
        PersonalInformationEntity personalInfo = new PersonalInformationEntity();
        ProfessionalProfileEntity entity1 = new ProfessionalProfileEntity();
        entity1.setId(id);
        entity1.setProfileName("Developer");
        entity1.setDescription("Software Developer");
        entity1.setFkPersonalInformation(personalInfo);
        entity1.setActive(true);

        ProfessionalProfileEntity entity2 = new ProfessionalProfileEntity();
        entity2.setId(id);
        entity2.setProfileName("Developer");
        entity2.setDescription("Software Developer");
        entity2.setFkPersonalInformation(personalInfo);
        entity2.setActive(true);

        assertEquals(entity1, entity2);
        assertEquals(entity1.hashCode(), entity2.hashCode());
    }

    @Test
    @DisplayName("ProfessionalProfileEntity not equals different id")
    void professionalProfileEntityNotEqualsDifferentId() {
        PersonalInformationEntity personalInfo = new PersonalInformationEntity();
        ProfessionalProfileEntity entity1 = new ProfessionalProfileEntity();
        entity1.setId(UUID.randomUUID());
        entity1.setProfileName("Developer");
        entity1.setDescription("Software Developer");
        entity1.setFkPersonalInformation(personalInfo);
        entity1.setActive(true);

        ProfessionalProfileEntity entity2 = new ProfessionalProfileEntity();
        entity2.setId(UUID.randomUUID());
        entity2.setProfileName("Developer");
        entity2.setDescription("Software Developer");
        entity2.setFkPersonalInformation(personalInfo);
        entity2.setActive(true);

        assertNotEquals(entity1, entity2);
    }

    @Test
    @DisplayName("ProfessionalProfileEntity not equals different profile name")
    void professionalProfileEntityNotEqualsDifferentProfileName() {
        UUID id = UUID.randomUUID();
        PersonalInformationEntity personalInfo = new PersonalInformationEntity();
        ProfessionalProfileEntity entity1 = new ProfessionalProfileEntity();
        entity1.setId(id);
        entity1.setProfileName("Developer");
        entity1.setDescription("Software Developer");
        entity1.setFkPersonalInformation(personalInfo);
        entity1.setActive(true);

        ProfessionalProfileEntity entity2 = new ProfessionalProfileEntity();
        entity2.setId(id);
        entity2.setProfileName("Designer");
        entity2.setDescription("Software Developer");
        entity2.setFkPersonalInformation(personalInfo);
        entity2.setActive(true);

        assertNotEquals(entity1, entity2);
    }

    @Test
    @DisplayName("ProfessionalProfileEntity toString")
    void professionalProfileEntityToString() {
        UUID id = UUID.randomUUID();
        PersonalInformationEntity personalInfo = new PersonalInformationEntity();
        ProfessionalProfileEntity entity = new ProfessionalProfileEntity();
        entity.setId(id);
        entity.setProfileName("Developer");
        entity.setDescription("Software Developer");
        entity.setFkPersonalInformation(personalInfo);
        entity.setActive(true);

        String expected = "ProfessionalProfileEntity{id=" + id + ", profileName='Developer', description='Software Developer', fkPersonalInformation=" + personalInfo + ", active=true}";
        assertEquals(expected, entity.toString());
    }
}
