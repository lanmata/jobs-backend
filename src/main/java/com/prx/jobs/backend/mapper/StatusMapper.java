package com.prx.jobs.backend.mapper;

import com.prx.jobs.backend.api.to.StatusTO;
import com.prx.jobs.backend.config.MapperAppConfig;
import com.prx.jobs.backend.jpa.entity.StatusEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MapperConfig;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import java.util.List;

/**
 * Mapper for the entity {@link StatusEntity} and its DTO {@link StatusTO}.
 */
@Mapper(
        // Specifies that the mapper should be a Spring bean.
        uses = {StatusEntity.class, StatusTO.class},
        // Specifies the configuration class to use for this mapper.
        config = MapperAppConfig.class
)
@MapperConfig(unmappedTargetPolicy = ReportingPolicy.ERROR, unmappedSourcePolicy = ReportingPolicy.ERROR)
public interface StatusMapper {

    StatusTO toTarget(StatusEntity statusEntity);

    StatusEntity toSource(StatusTO statusTO);

    List<StatusTO> toTarget(List<StatusEntity> statusEntity);

    List<StatusEntity> toSource(List<StatusTO> statusTO);
}
