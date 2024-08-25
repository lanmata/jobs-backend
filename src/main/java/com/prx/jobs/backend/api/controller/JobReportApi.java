package com.prx.jobs.backend.api.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.prx.jobs.backend.api.service.JobReportService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

import static com.prx.commons.util.DateUtil.PATTERN_DATE_TIME;

/**
 * The JobReportApi interface.
 * This interface defines the API for generating job reports.
 */
@Tag(name = "report", description = "The report API")
public interface JobReportApi {

    /**
     * Gets the job report service.
     *
     * @return The job report service.
     */
    default JobReportService getService() {
        return new JobReportService() {
        };
    }

    /**
     * This method generates a report of job offers.
     *
     * @param startDate The start date of the report.
     * @param endDate   The end date of the report.
     * @return A byte array containing the report.
     */
    @Operation(summary = "Generates a report of job offers",
            description = "Generates a report of job offers between the specified start and end dates.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Report generated successfully",
                    content = @Content(mediaType = MediaType.APPLICATION_OCTET_STREAM_VALUE,
                            schema = @Schema(type = "string", format = "binary"))),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @GetMapping(produces = {MediaType.APPLICATION_OCTET_STREAM_VALUE})
    default ResponseEntity<byte[]> generateReport(
            @Parameter(name = "startDate", description = "The start date of the report", required = true)
            @RequestParam(value = "startDate") @JsonFormat(pattern = PATTERN_DATE_TIME) LocalDate startDate,
            @Parameter(name = "endDate", description = "The end date of the report", required = true)
            @RequestParam(value = "endDate") @JsonFormat(pattern = PATTERN_DATE_TIME) LocalDate endDate) {
        return this.getService().generateJobsReport(startDate, endDate);
    }
}
