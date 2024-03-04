package com.prx.jobs.backend.mapper;

import com.prx.jobs.backend.api.to.StatusTO;
import com.prx.jobs.backend.api.to.TermTO;
import com.prx.jobs.backend.config.MapperAppConfig;
import com.prx.jobs.backend.jpa.entity.StatusEntity;
import com.prx.jobs.backend.jpa.entity.TermEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MapperConfig;
import org.mapstruct.ReportingPolicy;

import java.util.List;

/**
 * Mapper for the entity {@link TermEntity} and its DTO {@link TermTO}.
 */
@Mapper(
        // Specifies that the mapper should be a Spring bean.
        uses = {TermEntity.class, TermTO.class},
        // Specifies the configuration class to use for this mapper.
        config = MapperAppConfig.class
)
@MapperConfig(unmappedTargetPolicy = ReportingPolicy.ERROR, unmappedSourcePolicy = ReportingPolicy.ERROR)
public interface TermMapper {

    StatusTO toTarget(TermEntity termEntity);

    StatusEntity toSource(TermTO statusTO);

    List<TermTO> toTarget(List<TermEntity> termEntity);

    List<TermEntity> toSource(List<TermTO> termTO);
}
