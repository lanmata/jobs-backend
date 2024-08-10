package com.prx.jobs.backend.mapper;

import com.prx.jobs.backend.api.to.CompanyTO;
import com.prx.jobs.backend.config.MapperAppConfig;
import com.prx.jobs.backend.jpa.entity.CompanyEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MapperConfig;
import org.mapstruct.ReportingPolicy;

import java.util.List;

/**
 * Mapper for the entity {@link CompanyEntity} and its DTO {@link CompanyTO}.
 */
@Mapper(
        // Specifies that the mapper should be a Spring bean.
        uses = {CompanyEntity.class, CompanyTO.class},
        // Specifies the configuration class to use for this mapper.
        config = MapperAppConfig.class
)
@MapperConfig(unmappedTargetPolicy = ReportingPolicy.ERROR, unmappedSourcePolicy = ReportingPolicy.ERROR)
public interface CompanyMapper {

    /**
     * Converts a CompanyEntity object to a CompanyTO object.
     *
     * @param companyEntity The CompanyEntity object to convert.
     * @return The converted CompanyTO object.
     */
    CompanyTO toTarget(CompanyEntity companyEntity);

    /**
     * Converts a CompanyTO object to a CompanyEntity object.
     *
     * @param companyTO The CompanyTO object to convert.
     * @return The converted CompanyEntity object.
     */
    CompanyEntity toSource(CompanyTO companyTO);

    /**
     * Converts a list of CompanyEntity objects to a list of CompanyTO objects.
     *
     * @param companyEntityList The list of CompanyEntity objects to convert.
     * @return The converted list of CompanyTO objects.
     */
    List<CompanyTO> toTarget(List<CompanyEntity> companyEntityList);

    /**
     * Converts a list of CompanyTO objects to a list of ModeEntity objects.
     *
     * @param companyTOList The list of CompanyTO objects to convert.
     * @return The converted list of CompanyEntity objects.
     */
    List<CompanyEntity> toSource(List<CompanyTO> companyTOList);
}
