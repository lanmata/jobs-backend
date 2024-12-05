package com.prx.jobs.backend.jpa.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.ColumnDefault;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "professional_profile", schema = "jobs")
public class ProfessionalProfileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @ColumnDefault("jobs.uuid_generate_v4()")
    @Column(name = "id", nullable = false)
    private UUID id;

    @Size(max = 50)
    @NotNull
    @Column(name = "profile_name", nullable = false, length = 50)
    private String profileName;

    @Size(max = 255)
    @NotNull
    @Column(name = "description", nullable = false)
    private String description;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_personal_information", nullable = false)
    private PersonalInformationEntity fkPersonalInformationEntity;

    @NotNull
    @ColumnDefault("true")
    @Column(name = "active", nullable = false)
    private Boolean active = false;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PersonalInformationEntity getFkPersonalInformation() {
        return fkPersonalInformationEntity;
    }

    public void setFkPersonalInformation(PersonalInformationEntity fkPersonalInformationEntity) {
        this.fkPersonalInformationEntity = fkPersonalInformationEntity;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "ProfessionalProfileEntity{" +
                "id=" + id +
                ", profileName='" + profileName + '\'' +
                ", description='" + description + '\'' +
                ", fkPersonalInformation=" + fkPersonalInformationEntity +
                ", active=" + active +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ProfessionalProfileEntity that)) return false;
        return Objects.equals(id, that.id) && Objects.equals(profileName, that.profileName) && Objects.equals(description, that.description) && Objects.equals(fkPersonalInformationEntity, that.fkPersonalInformationEntity) && Objects.equals(active, that.active);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, profileName, description, fkPersonalInformationEntity, active);
    }
}
