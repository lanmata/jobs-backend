package com.prx.jobs.backend.mapper;

import com.prx.jobs.backend.api.to.TermTO;
import com.prx.jobs.backend.config.jackson.MapperAppConfig;
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

    /**
     * Converts a TermEntity object to a TermTO object.
     *
     * @param termEntity The TermEntity object to convert.
     * @return The converted TermTO object.
     */
    TermTO toTarget(TermEntity termEntity);

    /**
     * Converts a TermTO object to a TermEntity object.
     *
     * @param termTO The TermTO object to convert.
     * @return The converted TermEntity object.
     */
    TermEntity toSource(TermTO termTO);

    /**
     * Converts a list of TermEntity objects to a list of TermTO objects.
     *
     * @param termEntity The list of TermEntity objects to convert.
     * @return The converted list of TermTO objects.
     */
    List<TermTO> toTarget(List<TermEntity> termEntity);

    /**
     * Converts a list of TermTO objects to a list of TermEntity objects.
     *
     * @param termTO The list of TermTO objects to convert.
     * @return The converted list of TermEntity objects.
     */
    List<TermEntity> toSource(List<TermTO> termTO);
}
