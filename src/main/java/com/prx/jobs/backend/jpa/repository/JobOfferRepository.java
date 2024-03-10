package com.prx.jobs.backend.jpa.repository;

import com.prx.jobs.backend.jpa.entity.JobOfferEntity;
import com.prx.jobs.backend.util.JobsConstants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * JobOfferRepository
 */
public interface JobOfferRepository extends JpaRepository<JobOfferEntity, UUID> {

    /**
     * The findJobOfferEntitiesByJobOfferId method returns a list of job offer entities.
     *
     * @return A list of job offer entities.
     */
    @Query(nativeQuery = true, value = JobsConstants.JOB_OFFER_CONTENT_DETAIL)
    Optional<List<Object[][]>> findJobOfferEntities();
}
