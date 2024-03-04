package com.prx.jobs.backend.jpa.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

/**
 * This is the PostDetailEntity class.
 * It is annotated with @Entity to indicate that it is a JPA entity.
 * It is annotated with @Table to specify the table to which this entity is mapped.
 */
@Entity
@Table(name = "post_detail", schema = "jobs")
public class PostDetailEntity {
    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @Size(max = 1000)
    @Column(name = "description", length = 1000)
    private String description;

    @NotNull
    @Column(name = "datetime", nullable = false)
    private Instant datetime;

    @NotNull
    @Column(name = "mount_rate", nullable = false, precision = 10, scale = 2)
    private BigDecimal mountRate;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_post", nullable = false)
    private PostEntity post;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_status", nullable = false)
    private StatusEntity status;

    public PostDetailEntity() {
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

    public Instant getDatetime() {
        return datetime;
    }

    public void setDatetime(Instant datetime) {
        this.datetime = datetime;
    }

    public BigDecimal getMountRate() {
        return mountRate;
    }

    public void setMountRate(BigDecimal mountRate) {
        this.mountRate = mountRate;
    }

    public PostEntity getPost() {
        return post;
    }

    public void setPost(PostEntity post) {
        this.post = post;
    }

    public StatusEntity getStatus() {
        return status;
    }

    public void setStatus(StatusEntity status) {
        this.status = status;
    }

}
