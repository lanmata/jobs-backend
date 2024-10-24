package com.prx.jobs.backend.mapper;

import com.prx.jobs.backend.api.to.SourceTypeTO;
import com.prx.jobs.backend.config.jackson.MapperAppConfig;
import com.prx.jobs.backend.jpa.entity.SourceTypeEntity;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * Mapper for the entity {@link SourceTypeEntity} and its DTO {@link SourceTypeTO}.
 */
@Mapper(
        // Specifies that the mapper should be a Spring bean.
        uses = {SourceTypeEntity.class, SourceTypeTO.class},
        // Specifies the configuration class to use for this mapper.
        config = MapperAppConfig.class
)
public interface SourceTypeMapper {

    /**
     * Converts a SourceTypeEntity object to a SourceTypeTO object.
     *
     * @param sourceTypeEntity The SourceTypeEntity object to convert.
     * @return The converted SourceTypeTO object.
     */
    SourceTypeTO toTarget(SourceTypeEntity sourceTypeEntity);

    /**
     * Converts a SourceTypeTO object to a SourceTypeEntity object.
     *
     * @param sourceTypeTO The SourceTypeTO object to convert.
     * @return The converted SourceTypeEntity object.
     */
    SourceTypeEntity toSource(SourceTypeTO sourceTypeTO);

    /**
     * Converts a list of SourceTypeEntity objects to a list of SourceTypeTO objects.
     *
     * @param sourceTypeEntityList The list of SourceTypeEntity objects to convert.
     * @return The converted list of SourceTypeTO objects.
     */
    List<SourceTypeTO> toTarget(List<SourceTypeEntity> sourceTypeEntityList);

    /**
     * Converts a list of SourceTypeTO objects to a list of SourceTypeEntity objects.
     *
     * @param sourceTypeTOList The list of SourceTypeTO objects to convert.
     * @return The converted list of SourceTypeEntity objects.
     */
    List<SourceTypeEntity> toSource(List<SourceTypeTO> sourceTypeTOList);
}
