package com.prx.jobs.backend.mapper;

import com.prx.jobs.backend.api.to.JobOfferDetailTO;
import com.prx.jobs.backend.config.MapperAppConfig;
import com.prx.jobs.backend.jpa.entity.JobOfferDetailEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(
        // Specifies the configuration class to use for this mapper.
        config = MapperAppConfig.class
)
public interface JobOfferDetailMapper {

    /**
     * Converts a PostDetailEntity object to a PostDetailTO object.
     * @param jobOfferDetailEntity The PostDetailEntity object to convert.
     * @return The converted PostDetailTO object.
     */
    @Mapping(target = "jobOfferId", source = "post.id")
    @Mapping(target = "statusId", source = "status.id")
    JobOfferDetailTO toTarget(JobOfferDetailEntity jobOfferDetailEntity);

    /**
     * Converts a PostDetailTO object to a PostDetailEntity object.
     * @param jobOfferDetailTO The PostDetailTO object to convert.
     * @return The converted PostDetailEntity object.
     */
    @InheritInverseConfiguration
    JobOfferDetailEntity toSource(JobOfferDetailTO jobOfferDetailTO);

    /**
     * Converts a list of PostDetailEntity objects to a list of PostDetailTO objects.
     * @param jobOfferDetailEntityList The list of PostDetailEntity objects to convert.
     * @return The converted list of PostDetailTO objects.
     */
    List<JobOfferDetailTO> toTarget(List<JobOfferDetailEntity> jobOfferDetailEntityList);

    /**
     * Converts a list of PostDetailTO objects to a list of PostDetailEntity objects.
     * @param jobOfferDetailTOList The list of PostDetailTO objects to convert.
     * @return The converted list of PostDetailEntity objects.
     */
    List<JobOfferDetailEntity> toSource(List<JobOfferDetailTO> jobOfferDetailTOList);
}
