package com.prx.jobs.backend.jpa.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class PersonalInformationEntityTest {

    @Test
    @DisplayName("PersonalInformationEntity equals and hashCode")
    void personalInformationEntityEqualsAndHashCode() {
        UUID id = UUID.randomUUID();
        PersonalInformationEntity entity1 = new PersonalInformationEntity();
        entity1.setId(id);
        entity1.setName("John");
        entity1.setLastname("Doe");
        entity1.setDayOfBirth(LocalDate.of(1990, 1, 1));

        PersonalInformationEntity entity2 = new PersonalInformationEntity();
        entity2.setId(id);
        entity2.setName("John");
        entity2.setLastname("Doe");
        entity2.setDayOfBirth(LocalDate.of(1990, 1, 1));

        assertEquals(entity1, entity2);
        assertEquals(entity1.hashCode(), entity2.hashCode());
    }

    @Test
    @DisplayName("PersonalInformationEntity not equals different id")
    void personalInformationEntityNotEqualsDifferentId() {
        PersonalInformationEntity entity1 = new PersonalInformationEntity();
        entity1.setId(UUID.randomUUID());
        entity1.setName("John");
        entity1.setLastname("Doe");
        entity1.setDayOfBirth(LocalDate.of(1990, 1, 1));

        PersonalInformationEntity entity2 = new PersonalInformationEntity();
        entity2.setId(UUID.randomUUID());
        entity2.setName("John");
        entity2.setLastname("Doe");
        entity2.setDayOfBirth(LocalDate.of(1990, 1, 1));

        assertNotEquals(entity1, entity2);
    }

    @Test
    @DisplayName("PersonalInformationEntity not equals different name")
    void personalInformationEntityNotEqualsDifferentName() {
        UUID id = UUID.randomUUID();
        PersonalInformationEntity entity1 = new PersonalInformationEntity();
        entity1.setId(id);
        entity1.setName("John");
        entity1.setLastname("Doe");
        entity1.setDayOfBirth(LocalDate.of(1990, 1, 1));

        PersonalInformationEntity entity2 = new PersonalInformationEntity();
        entity2.setId(id);
        entity2.setName("Jane");
        entity2.setLastname("Doe");
        entity2.setDayOfBirth(LocalDate.of(1990, 1, 1));

        assertNotEquals(entity1, entity2);
    }

    @Test
    @DisplayName("PersonalInformationEntity toString")
    void personalInformationEntityToString() {
        UUID id = UUID.randomUUID();
        PersonalInformationEntity entity = new PersonalInformationEntity();
        entity.setId(id);
        entity.setName("John");
        entity.setLastname("Doe");
        entity.setDayOfBirth(LocalDate.of(1990, 1, 1));

        String expected = "PersonalInformationEntity{id=" + id + ", name='John', lastname='Doe', dayOfBirth=1990-01-01}";
        assertEquals(expected, entity.toString());
    }
}
