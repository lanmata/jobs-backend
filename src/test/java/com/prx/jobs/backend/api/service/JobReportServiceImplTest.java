package com.prx.jobs.backend.api.service;

import com.prx.jobs.backend.jpa.entity.JobReportEntity;
import com.prx.jobs.backend.jpa.repository.JobReportRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(value = {SpringExtension.class})
class JobReportServiceImplTest {

    @InjectMocks
    private JobReportServiceImpl jobReportService;

    @Mock
    private JobReportRepository jobReportRepository;


    @Test
    @DisplayName("Should generate report when data is present")
    void shouldGenerateReportWhenDataIsPresent() {
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = LocalDate.now();
        var jobReportEntity = new JobReportEntity();
        jobReportEntity.setId(UUID.randomUUID());
        jobReportEntity.setCreatedDate(LocalDateTime.of(2021, 1, 1, 0, 0));
        jobReportEntity.setLastModifiedDate(LocalDateTime.of(2021, 1, 12, 0, 0));
        jobReportEntity.setCompany("company");
        jobReportEntity.setMode("mode");
        jobReportEntity.setMount(BigDecimal.valueOf(100.0));
        jobReportEntity.setStatus("status");
        jobReportEntity.setTerm("term");
        jobReportEntity.setPosition("position");

        when(jobReportRepository.findJobReportEntityByJobReportId(startDate, endDate))
                .thenReturn(Optional.of(List.of(jobReportEntity)));

        ResponseEntity<byte[]> response = jobReportService.generateJobsReport(startDate, endDate);

        assertNotNull(response.getBody());
        assertTrue(response.getBody().length > 0);
    }

    @Test
    @DisplayName("Should return no content when no data is present")
    void shouldReturnNoContentWhenNoDataIsPresent() {
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = LocalDate.now();
        when(jobReportRepository.findJobReportEntityByJobReportId(startDate, endDate))
                .thenReturn(Optional.empty());

        ResponseEntity<byte[]> response = jobReportService.generateJobsReport(startDate, endDate);

        assertNull(response.getBody());
    }

    @Test
    @DisplayName("Should throw exception when start date is after end date")
    void shouldThrowExceptionWhenStartDateIsAfterEndDate() {
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = startDate.minusDays(1);

        assertThrows(IllegalArgumentException.class, () -> jobReportService.generateJobsReport(startDate, endDate));
    }

    @Test
    @DisplayName("Should throw exception when start date is null")
    void shouldThrowExceptionWhenStartDateIsNull() {
        LocalDate endDate = LocalDate.now();

        assertThrows(NullPointerException.class, () -> jobReportService.generateJobsReport(null, endDate));
    }

    @Test
    @DisplayName("Should throw exception when end date is null")
    void shouldThrowExceptionWhenEndDateIsNull() {
        LocalDate startDate = LocalDate.now();

        assertThrows(NullPointerException.class, () -> jobReportService.generateJobsReport(startDate, null));
    }

}
