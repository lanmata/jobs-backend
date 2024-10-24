package com.prx.jobs.backend.mapper;

import com.prx.jobs.backend.api.to.ModeTO;
import com.prx.jobs.backend.config.jackson.MapperAppConfig;
import com.prx.jobs.backend.jpa.entity.ModeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MapperConfig;
import org.mapstruct.ReportingPolicy;

import java.util.List;

/**
 * Mapper for the entity {@link ModeEntity} and its DTO {@link ModeTO}.
 */
@Mapper(
        // Specifies that the mapper should be a Spring bean.
        uses = {ModeEntity.class, ModeTO.class},
        // Specifies the configuration class to use for this mapper.
        config = MapperAppConfig.class
)
@MapperConfig(unmappedTargetPolicy = ReportingPolicy.ERROR, unmappedSourcePolicy = ReportingPolicy.ERROR)
public interface ModeMapper {

    /**
     * Converts a ModeEntity object to a ModeTO object.
     *
     * @param modeEntity The ModeEntity object to convert.
     * @return The converted ModeTO object.
     */
    ModeTO toTarget(ModeEntity modeEntity);

    /**
     * Converts a ModeTO object to a ModeEntity object.
     *
     * @param modeTO The ModeTO object to convert.
     * @return The converted ModeEntity object.
     */
    ModeEntity toSource(ModeTO modeTO);

    /**
     * Converts a list of ModeEntity objects to a list of ModeTO objects.
     *
     * @param modeEntity The list of ModeEntity objects to convert.
     * @return The converted list of ModeTO objects.
     */
    List<ModeTO> toTarget(List<ModeEntity> modeEntity);

    /**
     * Converts a list of ModeTO objects to a list of ModeEntity objects.
     *
     * @param modeTO The list of ModeTO objects to convert.
     * @return The converted list of ModeEntity objects.
     */
    List<ModeEntity> toSource(List<ModeTO> modeTO);
}
