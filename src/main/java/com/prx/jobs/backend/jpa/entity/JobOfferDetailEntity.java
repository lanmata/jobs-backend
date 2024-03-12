package com.prx.jobs.backend.jpa.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * This is the JobOfferDetailEntity class.
 * It is annotated with @Entity to indicate that it is a JPA entity.
 * It is annotated with @Table to specify the table to which this entity is mapped.
 */
@Entity
@Table(name = "job_offer_detail", schema = "jobs")
public class JobOfferDetailEntity {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Size(max = 1000)
    @Column(name = "description", length = 1000)
    private String description;

    @NotNull
    @Column(name = "datetime", nullable = false)
    private LocalDateTime datetime;

    @NotNull
    @Column(name = "mount_rate", nullable = false, precision = 10, scale = 2)
    private BigDecimal mountRate;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_job_offer", nullable = false)
    private JobOfferEntity offerEntity;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_status", nullable = false)
    private StatusEntity status;

    public JobOfferDetailEntity() {
        // Default constructor
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDateTime datetime) {
        this.datetime = datetime;
    }

    public BigDecimal getMountRate() {
        return mountRate;
    }

    public void setMountRate(BigDecimal mountRate) {
        this.mountRate = mountRate;
    }

    public JobOfferEntity getOfferEntity() {
        return offerEntity;
    }

    public void setOfferEntity(JobOfferEntity jobOffer) {
        this.offerEntity = jobOffer;
    }

    public StatusEntity getStatus() {
        return status;
    }

    public void setStatus(StatusEntity status) {
        this.status = status;
    }

}
