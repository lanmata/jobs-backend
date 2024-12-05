package com.prx.jobs.backend.jpa.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "personal_information", schema = "jobs")
public class PersonalInformationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @ColumnDefault("jobs.uuid_generate_v4()")
    @Column(name = "id", nullable = false)
    private UUID id;

    @Size(max = 30)
    @NotNull
    @Column(name = "name", nullable = false, length = 30)
    private String name;

    @Size(max = 30)
    @NotNull
    @Column(name = "lastname", nullable = false, length = 30)
    private String lastname;

    @NotNull
    @Column(name = "day_of_birth", nullable = false)
    private LocalDate dayOfBirth;

    public PersonalInformationEntity() {
        // Default constructor
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public LocalDate getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(LocalDate dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    @Override
    public String toString() {
        return "PersonalInformationEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", dayOfBirth=" + dayOfBirth +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof PersonalInformationEntity that)) return false;
        return Objects.equals(id, that.id)
                && Objects.equals(name, that.name)
                && Objects.equals(lastname, that.lastname)
                && Objects.equals(dayOfBirth, that.dayOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastname, dayOfBirth);
    }
}
