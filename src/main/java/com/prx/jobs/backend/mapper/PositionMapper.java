package com.prx.jobs.backend.mapper;

import com.prx.jobs.backend.api.to.PositionTO;
import com.prx.jobs.backend.api.to.PostPositionRequest;
import com.prx.jobs.backend.config.jackson.MapperAppConfig;
import com.prx.jobs.backend.jpa.entity.PositionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * Mapper for the entity {@link PositionEntity} and its DTO {@link PositionTO}.
 */
@Mapper(
        // Specifies that the mapper should be a Spring bean.
        uses = {PositionEntity.class, PositionTO.class},
        // Specifies the configuration class to use for this mapper.
        config = MapperAppConfig.class
)
public interface PositionMapper {

    /**
     * Converts a PositionEntity object to a PositionTO object.
     *
     * @param positionEntity The PositionEntity object to convert.
     * @return The converted PositionTO object.
     */
    PositionTO toTarget(PositionEntity positionEntity);

    /**
     * Converts a PositionTO object to a PositionEntity object.
     *
     * @param modeTO The PositionTO object to convert.
     * @return The converted PositionEntity object.
     */
    PositionEntity toSource(PositionTO modeTO);

    /**
     * Converts a list of PositionEntity objects to a list of PositionTO objects.
     *
     * @param positionEntityList The list of PositionEntity objects to convert.
     * @return The converted list of PositionTO objects.
     */
    List<PositionTO> toTarget(List<PositionEntity> positionEntityList);

    /**
     * Converts a list of PositionTO objects to a list of PositionEntity objects.
     *
     * @param positionTOList The list of PositionTO objects to convert.
     * @return The converted list of PositionEntity objects.
     */
    List<PositionEntity> toSource(List<PositionTO> positionTOList);

    /**
     * Converts a PostPositionRequest object to a PositionEntity object.
     *
     * @param request The PostPositionRequest object to convert.
     * @return The converted PositionEntity object.
     */
    @Mapping(target = "id", ignore = true)
    PositionEntity toSource(PostPositionRequest request);
}
