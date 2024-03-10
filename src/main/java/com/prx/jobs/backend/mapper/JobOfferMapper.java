package com.prx.jobs.backend.mapper;

import com.prx.jobs.backend.api.to.GetJobOfferResponse;
import com.prx.jobs.backend.api.to.PostJobOfferResponse;
import com.prx.jobs.backend.jpa.entity.JobOfferEntity;
import org.mapstruct.*;

@Mapper(
        // Specifies that the mapper should be a Spring bean.
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {JobOfferEntity.class, GetJobOfferResponse.class, PostJobOfferResponse.class}
)
@MapperConfig(
        // Specifies that the mapper should fail if there are any unmapped properties.
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        // Specifies that the mapper should fail if there are any unmapped properties.
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface JobOfferMapper {

    /**
     * Converts a PostEntity object to a GetPostResponse object.
     *
     * @param jobOfferEntity The PostEntity object to convert.
     * @return The converted GetPostResponse object.
     */
    @Mapping(target = "companyId", source = "company.id")
    @Mapping(target = "company", source = "company.name")
    @Mapping(target = "modeId", source = "mode.id")
    @Mapping(target = "mode", source = "mode.name")
    @Mapping(target = "positionId", source = "position.id")
    @Mapping(target = "position", source = "position.name")
    @Mapping(target = "sourceId", source = "source.id")
    @Mapping(target = "source", source = "source.name")
    @Mapping(target = "termId", source = "term.id")
    @Mapping(target = "term", source = "term.name")
    @Mapping(target = "postDetailList", ignore = true)
    GetJobOfferResponse toTarget(JobOfferEntity jobOfferEntity);

    /**
     * Converts a PostEntity object to a PostPostResponse object.
     *
     * @param jobOfferEntity The PostEntity object to convert.
     * @return The converted PostPostResponse object.
     */
    @Mapping(target = "id", source = "id")
    @Mapping(target = "message", ignore = true)
    @Mapping(target = "createdDate", ignore = true)
    PostJobOfferResponse toPostJobOfferResponse(JobOfferEntity jobOfferEntity);

}
