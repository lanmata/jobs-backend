package com.prx.jobs.backend.jpa.repository;

import com.prx.jobs.backend.jpa.entity.JobOfferDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository for JobOfferDetailEntity
 */
public interface JobOfferDetailRepository extends JpaRepository<JobOfferDetailEntity, UUID> {

    /**
     * Finds job offer detail entities by job offer id.
     *
     * @param jobOfferId The job offer id to search for.
     * @return Optional<List < JobOfferDetailEntity>>.
     */
    @Query("SELECT p FROM JobOfferDetailEntity p WHERE p.offerEntity.id = :jobOfferId")
    Optional<List<JobOfferDetailEntity>> findJobOfferDetailEntitiesByPostId(@Param("jobOfferId") UUID jobOfferId);
}
