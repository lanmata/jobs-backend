package com.prx.jobs.backend.api.service;

import com.prx.commons.util.DateUtil;
import com.prx.jobs.backend.JobReportKey;
import com.prx.jobs.backend.jpa.entity.JobReportEntity;
import com.prx.jobs.backend.jpa.repository.JobReportRepository;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.xssf.usermodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

import static org.springframework.http.HttpHeaders.CONTENT_DISPOSITION;

/**
 * JobReportServiceImpl
 */
@Service
public class JobReportServiceImpl implements JobReportService {

    /**
     * The logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(JobReportServiceImpl.class);
    /**
     * The job report repository.
     */
    private final JobReportRepository jobReportRepository;

    /**
     * Default constructor
     *
     * @param jobReportRepository The job report repository.
     */
    public JobReportServiceImpl(JobReportRepository jobReportRepository) {
        this.jobReportRepository = jobReportRepository;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<byte[]> generateJobsReport(LocalDate startDate, LocalDate endDate) {
        Objects.requireNonNull(startDate, "Start date is required.");
        Objects.requireNonNull(endDate, "End date is required.");
        if (startDate.isAfter(endDate)) {
            throw new IllegalArgumentException("Start date must be before end date.");
        }
        var result = jobReportRepository.findJobReportEntityByJobReportId(startDate, endDate);
        AtomicReference<ResponseEntity<byte[]>> responseEntity = new AtomicReference<>(ResponseEntity.noContent().build());
        result.ifPresentOrElse(jobReportEntities -> {
            var report = generateReport(jobReportEntities);
            if (report.length > 0) {
                responseEntity.set(ResponseEntity.ok()
                        .header(CONTENT_DISPOSITION, "attachment; filename=job-report-"
                                + LocalDateTime.now().format(DateTimeFormatter.ofPattern(
                                DateUtil.PATTERN_DATETIME_YYMMDDHHMMSS)) + ".xlsx")
                        .body(report));
            } else {
                LOGGER.warn("Fail to generate report.");
                responseEntity.set(ResponseEntity.noContent().build());
            }
        }, () -> {
            LOGGER.warn("No data found for the given dates.");
            responseEntity.set(ResponseEntity.noContent().build());
        });
        return responseEntity.get();
    }

    /**
     * Generate report
     *
     * @param jobReportEntities The list of job report entities.
     * @return The byte array.
     */
    private byte[] generateReport(List<JobReportEntity> jobReportEntities) {
        if (Objects.isNull(jobReportEntities) || jobReportEntities.isEmpty()) {
            return new byte[0];
        }
        try (XSSFWorkbook workbook = new XSSFWorkbook();
             ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {

            var sheet = workbook.createSheet("Job Report");
            var row = sheet.createRow(0);
            // Create a new font and alter it.
            XSSFFont font = workbook.createFont();
            // Create a new data format
            DataFormat format = workbook.createDataFormat();
            // Convert hex color to RGB
            font.setFontHeightInPoints((short) 12);
            font.setBold(true);
            font.setColor(new XSSFColor(Color.decode("#C0E6F5"), new DefaultIndexedColorMap()));
            // Create a CellStyle with the font
            XSSFCellStyle cellStyle = workbook.createCellStyle();
            XSSFCellStyle cellMountStyle = workbook.createCellStyle();
            cellMountStyle.setDataFormat(format.getFormat("#,##0.00"));
            cellStyle.setFont(font);
            cellStyle.setFillForegroundColor(new XSSFColor(Color.decode("#153D64"), new DefaultIndexedColorMap()));
            cellStyle.setAlignment(HorizontalAlignment.CENTER);
            cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            Arrays.stream(JobReportKey.values()).toList().forEach(jobReportKey -> {
                row.createCell(jobReportKey.getIndex()).setCellValue(jobReportKey.getKey());
                row.getCell(jobReportKey.getIndex()).setCellStyle(cellStyle);
                row.getCell(jobReportKey.getIndex()).getSheet().setColumnWidth(jobReportKey.getIndex(), jobReportKey.getWidth() * 256);
            });

            jobReportEntities.forEach(jobReportEntity -> {
                var row1 = sheet.createRow(jobReportEntities.indexOf(jobReportEntity) + 1);
                row1.createCell(JobReportKey.ID.getIndex()).setCellValue(jobReportEntity.getId().toString());

                row1.createCell(JobReportKey.MOUNT.getIndex()).setCellValue(jobReportEntity.getMount().doubleValue());
                row1.getCell(JobReportKey.MOUNT.getIndex()).setCellStyle(cellMountStyle);
                row1.createCell(JobReportKey.CREATED_DATE.getIndex()).setCellValue(jobReportEntity.getCreatedDate().format(DateTimeFormatter.ofPattern(DateUtil.PATTERN_DATE_TIME)));
                row1.createCell(JobReportKey.LAST_MODIFIED_DATE.getIndex()).setCellValue(jobReportEntity.getLastModifiedDate().format(DateTimeFormatter.ofPattern(DateUtil.PATTERN_DATE_TIME)));
                row1.createCell(JobReportKey.STATUS.getIndex()).setCellValue(jobReportEntity.getStatus());
                row1.createCell(JobReportKey.COMPANY.getIndex()).setCellValue(jobReportEntity.getCompany());
                row1.createCell(JobReportKey.POSITION.getIndex()).setCellValue(jobReportEntity.getPosition());
                row1.createCell(JobReportKey.TERM.getIndex()).setCellValue(jobReportEntity.getTerm());
                row1.createCell(JobReportKey.MODE.getIndex()).setCellValue(jobReportEntity.getMode());
                row1.createCell(JobReportKey.SOURCE.getIndex()).setCellValue(jobReportEntity.getSource());
            });

            workbook.write(outputStream);
            return outputStream.toByteArray();
        } catch (Exception e) {
            LOGGER.warn("Fail to generate report.", e);
        }
        return new byte[0];
    }
}
