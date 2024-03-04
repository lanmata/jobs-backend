package com.prx.jobs.backend.jpa.repository;

import com.prx.jobs.backend.jpa.entity.ModeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * ModeRepository
 */
public interface ModeRepository extends JpaRepository<ModeEntity, UUID> {
}
