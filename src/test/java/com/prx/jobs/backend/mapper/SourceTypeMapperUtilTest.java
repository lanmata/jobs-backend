package com.prx.jobs.backend.mapper;

import com.prx.jobs.backend.jpa.entity.SourceTypeEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class SourceTypeMapperUtilTest {

    private SourceTypeMapperUtil sourceTypeMapperUtil;

    @BeforeEach
    public void setup() {
        sourceTypeMapperUtil = new SourceTypeMapperUtil();
    }

    @Test
    void toTargetReturnsCorrectId() {
        SourceTypeEntity sourceTypeEntity = new SourceTypeEntity();
        UUID expectedId = UUID.randomUUID();
        sourceTypeEntity.setId(expectedId);

        UUID actualId = sourceTypeMapperUtil.toTarget(sourceTypeEntity);

        assertEquals(expectedId, actualId);
    }

    @Test
    void toSourceReturnsCorrectEntity() {
        UUID sourceTypeId = UUID.randomUUID();

        SourceTypeEntity actualEntity = sourceTypeMapperUtil.toSource(sourceTypeId);

        assertNotNull(actualEntity);
        assertEquals(sourceTypeId, actualEntity.getId());
    }

    @Test
    void toSourceReturnsEntityWithNullIdWhenIdIsNull() {
        SourceTypeEntity actualEntity = sourceTypeMapperUtil.toSource(null);

        assertNotNull(actualEntity);
        assertEquals(null, actualEntity.getId());
    }
}
