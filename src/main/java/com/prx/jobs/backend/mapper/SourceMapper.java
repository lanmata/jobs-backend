package com.prx.jobs.backend.mapper;

import com.prx.jobs.backend.api.to.SourceTO;
import com.prx.jobs.backend.config.jackson.MapperAppConfig;
import com.prx.jobs.backend.jpa.entity.SourceEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(
        // Specifies that the mapper should be a Spring bean.
        uses = {SourceTypeMapperUtil.class},
        // Specifies the configuration class to use for this mapper.
        config = MapperAppConfig.class
)
public interface SourceMapper {

    /**
     * Converts a SourceTO object to a SourceEntity object.
     *
     * @param sourceTO The SourceTO object to convert.
     * @return The converted SourceEntity object.
     */
    SourceEntity toSource(SourceTO sourceTO);

    /**
     * Converts a SourceEntity object to a SourceTO object.
     *
     * @param sourceEntity The SourceEntity object to convert.
     * @return The converted SourceTO object.
     */
    @InheritInverseConfiguration
    SourceTO toTarget(SourceEntity sourceEntity);

    /**
     * Converts a list of SourceTO objects to a list of SourceEntity objects.
     *
     * @param sourceTOList The list of SourceTO objects to convert.
     * @return The converted list of SourceEntity objects.
     */
    List<SourceEntity> toSource(List<SourceTO> sourceTOList);

    /**
     * Converts a list of SourceEntity objects to a list of SourceTO objects.
     *
     * @param sourceEntityList The list of SourceEntity objects to convert.
     * @return The converted list of SourceTO objects.
     */
    @InheritInverseConfiguration
    List<SourceTO> toTarget(List<SourceEntity> sourceEntityList);
}
