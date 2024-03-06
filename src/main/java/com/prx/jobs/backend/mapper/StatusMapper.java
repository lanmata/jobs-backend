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

    /**
     * Maps the entity {@link StatusEntity} to the DTO {@link StatusTO}.
     *
     * @param statusEntity The entity to map.
     * @return The mapped DTO.
     */
    StatusTO toTarget(StatusEntity statusEntity);

    /**
     * Maps the DTO {@link StatusTO} to the entity {@link StatusEntity}.
     *
     * @param statusTO The DTO to map.
     * @return The mapped entity.
     */
    StatusEntity toSource(StatusTO statusTO);

    /**
     * Maps a list of entities {@link StatusEntity} to a list of DTOs {@link StatusTO}.
     *
     * @param statusEntity The list of entities to map.
     * @return The mapped list of DTOs.
     */
    List<StatusTO> toTarget(List<StatusEntity> statusEntity);

    /**
     * Maps a list of DTOs {@link StatusTO} to a list of entities {@link StatusEntity}.
     *
     * @param statusTO The list of DTOs to map.
     * @return The mapped list of entities.
     */
    List<StatusEntity> toSource(List<StatusTO> statusTO);
}
