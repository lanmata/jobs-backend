package com.prx.jobs.backend.jpa.repository;

import com.prx.jobs.backend.jpa.entity.PersonalInformationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PersonalInformationRepository extends JpaRepository<PersonalInformationEntity, UUID> {
}
