package com.prx.jobs.backend.jpa.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.UUID;

/**
 * This is the PostEntity class.
 * It is annotated with @Entity to indicate that it is a JPA entity.
 * It is annotated with @Table to specify the table to which this entity is mapped.
 */
@Entity
@Table(name = "source", schema = "jobs")
public class SourceEntity {
    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @Size(max = 60)
    @NotNull
    @Column(name = "name", nullable = false, length = 60)
    private String name;

    @Size(max = 255)
    @NotNull
    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "active")
    private Boolean active;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_source_type", nullable = false)
    private SourceTypeEntity sourceType;

    public SourceEntity() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public SourceTypeEntity getSourceType() {
        return sourceType;
    }

    public void setSourceType(SourceTypeEntity sourceType) {
        this.sourceType = sourceType;
    }

}
