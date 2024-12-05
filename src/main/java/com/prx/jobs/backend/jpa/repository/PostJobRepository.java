package com.prx.jobs.backend.jpa.repository;

import com.prx.jobs.backend.jpa.entity.PostJobEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PostJobRepository extends JpaRepository<PostJobEntity, UUID> {
}
