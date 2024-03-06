package com.prx.jobs.backend.mapper;

import com.prx.jobs.backend.jpa.entity.SourceTypeEntity;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class SourceTypeMapperUtil {

    public UUID toTarget(SourceTypeEntity sourceTypeEntity) {
        return sourceTypeEntity.getId();
    }

    public SourceTypeEntity toSource(UUID sourceType) {
        var sourceTypeEntity = new SourceTypeEntity();
        sourceTypeEntity.setId(sourceType);
        return sourceTypeEntity;
    }
}
