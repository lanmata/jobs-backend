package com.prx.jobs.backend.mapper;

import com.prx.jobs.backend.api.to.GetPostResponse;
import com.prx.jobs.backend.config.MapperAppConfig;
import com.prx.jobs.backend.jpa.entity.PostEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
        // Specifies the configuration class to use for this mapper.
        config = MapperAppConfig.class
)
public interface PostMapper {

    /**
     * Converts a PostEntity object to a GetPostResponse object.
     *
     * @param postEntity The PostEntity object to convert.
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
    GetPostResponse toTarget(PostEntity postEntity);
}
