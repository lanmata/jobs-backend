package com.prx.jobs.backend.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.UUID;

/**
 * This is the TermEntity class.
 * It is annotated with @Entity to indicate that it is a JPA entity.
 * It is annotated with @Table to specify the table to which this entity is mapped.
 */
@Entity
@Table(name = "source_type", schema = "jobs")
public class SourceTypeEntity {
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

    public SourceTypeEntity() {
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

}
