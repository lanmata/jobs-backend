package com.prx.jobs.backend.mapper;

import com.prx.jobs.backend.api.to.PostDetailTO;
import com.prx.jobs.backend.config.MapperAppConfig;
import com.prx.jobs.backend.jpa.entity.PostDetailEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(
        // Specifies the configuration class to use for this mapper.
        config = MapperAppConfig.class
)
public interface PostDetailMapper {

    /**
     * Converts a PostDetailEntity object to a PostDetailTO object.
     * @param postDetailEntity The PostDetailEntity object to convert.
     * @return The converted PostDetailTO object.
     */
    @Mapping(target = "postId", source = "post.id")
    @Mapping(target = "statusId", source = "status.id")
    PostDetailTO toTarget(PostDetailEntity postDetailEntity);

    /**
     * Converts a PostDetailTO object to a PostDetailEntity object.
     * @param postDetailTO The PostDetailTO object to convert.
     * @return The converted PostDetailEntity object.
     */
    @InheritInverseConfiguration
    PostDetailEntity toSource(PostDetailTO postDetailTO);

    /**
     * Converts a list of PostDetailEntity objects to a list of PostDetailTO objects.
     * @param postDetailEntityList The list of PostDetailEntity objects to convert.
     * @return The converted list of PostDetailTO objects.
     */
    List<PostDetailTO> toTarget(List<PostDetailEntity> postDetailEntityList);

    /**
     * Converts a list of PostDetailTO objects to a list of PostDetailEntity objects.
     * @param postDetailTOList The list of PostDetailTO objects to convert.
     * @return The converted list of PostDetailEntity objects.
     */
    List<PostDetailEntity> toSource(List<PostDetailTO> postDetailTOList);
}
