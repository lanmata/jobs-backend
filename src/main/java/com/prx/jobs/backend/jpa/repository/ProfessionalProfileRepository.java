package com.prx.jobs.backend.jpa.repository;

import com.prx.jobs.backend.jpa.entity.ProfessionalProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProfessionalProfileRepository  extends JpaRepository<ProfessionalProfileEntity, UUID> {
}
