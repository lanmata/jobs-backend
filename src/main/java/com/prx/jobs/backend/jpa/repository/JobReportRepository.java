package com.prx.jobs.backend.jpa.repository;

import com.prx.jobs.backend.jpa.entity.JobReportEntity;
import com.prx.jobs.backend.util.JobsConstants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * JobReportRepository
 */
public interface JobReportRepository extends JpaRepository<JobReportEntity, UUID> {

    /**
     * The findJobReportEntityByJobReportId method returns a list of job report entities.
     *
     * @param startDate The start date of the report.
     * @param endDate   The end date of the report.
     * @return A list of job report entities.
     */
    @Query(nativeQuery = true, value = JobsConstants.JOB_REPORT_BY_DATE_RANGE)
    Optional<List<JobReportEntity>> findJobReportEntityByJobReportId(
            @Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
}
