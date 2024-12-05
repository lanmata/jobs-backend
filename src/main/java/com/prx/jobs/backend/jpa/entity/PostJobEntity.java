package com.prx.jobs.backend.jpa.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "post_job", schema = "jobs")
public class PostJobEntity {
    @EmbeddedId
    private PostJobPK id;

    @MapsId("fkJobOffer")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_job_offer", nullable = false)
    private JobOfferEntity fkJobOffer;

    @MapsId("fkProfessionalProfile")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_professional_profile", nullable = false)
    private ProfessionalProfileEntity fkProfessionalProfileEntity;

    @Size(max = 255)
    @NotNull
    @Column(name = "status", nullable = false)
    private String status;

    @NotNull
    @Column(name = "last_update", nullable = false)
    private LocalDate lastUpdate;

    public PostJobPK getId() {
        return id;
    }

    public void setId(PostJobPK id) {
        this.id = id;
    }

    public JobOfferEntity getFkJobOffer() {
        return fkJobOffer;
    }

    public void setFkJobOffer(JobOfferEntity fkJobOffer) {
        this.fkJobOffer = fkJobOffer;
    }

    public ProfessionalProfileEntity getFkProfessionalProfile() {
        return fkProfessionalProfileEntity;
    }

    public void setFkProfessionalProfile(ProfessionalProfileEntity fkProfessionalProfileEntity) {
        this.fkProfessionalProfileEntity = fkProfessionalProfileEntity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDate lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return "PostJobEntity{" +
                "id=" + id +
                ", fkJobOffer=" + fkJobOffer +
                ", fkProfessionalProfile=" + fkProfessionalProfileEntity +
                ", status='" + status + '\'' +
                ", lastUpdate=" + lastUpdate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof PostJobEntity postJobEntity)) return false;
        return Objects.equals(id, postJobEntity.id)
                && Objects.equals(fkJobOffer, postJobEntity.fkJobOffer)
                && Objects.equals(fkProfessionalProfileEntity, postJobEntity.fkProfessionalProfileEntity)
                && Objects.equals(status, postJobEntity.status) && Objects.equals(lastUpdate, postJobEntity.lastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fkJobOffer, fkProfessionalProfileEntity, status, lastUpdate);
    }
}
