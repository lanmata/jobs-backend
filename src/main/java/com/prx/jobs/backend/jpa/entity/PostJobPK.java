package com.prx.jobs.backend.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import org.hibernate.Hibernate;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Embeddable
public class PostJobPK implements Serializable {
    @Serial
    private static final long serialVersionUID = -1944432105306319864L;
    @NotNull
    @Column(name = "fk_job_offer", nullable = false)
    private UUID fkJobOffer;

    @NotNull
    @Column(name = "fk_professional_profile", nullable = false)
    private UUID fkProfessionalProfile;

    public PostJobPK() {
        // Default constructor
    }

    public UUID getFkJobOffer() {
        return fkJobOffer;
    }

    public void setFkJobOffer(UUID fkJobOffer) {
        this.fkJobOffer = fkJobOffer;
    }

    public UUID getFkProfessionalProfile() {
        return fkProfessionalProfile;
    }

    public void setFkProfessionalProfile(UUID fkProfessionalProfile) {
        this.fkProfessionalProfile = fkProfessionalProfile;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PostJobPK entity = (PostJobPK) o;
        return Objects.equals(this.fkProfessionalProfile, entity.fkProfessionalProfile) &&
                Objects.equals(this.fkJobOffer, entity.fkJobOffer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fkProfessionalProfile, fkJobOffer);
    }

}
