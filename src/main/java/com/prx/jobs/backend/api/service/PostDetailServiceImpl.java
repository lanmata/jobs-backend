package com.prx.jobs.backend.api.service;

import com.prx.jobs.backend.api.to.PostDetailTO;
import com.prx.jobs.backend.jpa.repository.PostDetailRepository;
import com.prx.jobs.backend.mapper.PostDetailMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PostDetailServiceImpl implements PostDetailService {

    /**
     * The PostDetailRepository object.
     */
    private final PostDetailRepository postDetailRepository;

    /**
     * The PostDetailMapper object.
     */
    private final PostDetailMapper postDetailMapper;

    /**
     * Constructor
     *
     * @param postDetailRepository The PostDetailRepository object.
     * @param postDetailMapper The PostDetailMapper object.
     */
    public PostDetailServiceImpl(PostDetailRepository postDetailRepository, PostDetailMapper postDetailMapper) {
        this.postDetailRepository = postDetailRepository;
        this.postDetailMapper = postDetailMapper;
    }

    /**{@inheritDoc}*/
    @Override
    public ResponseEntity<List<PostDetailTO>> findPostDetailByPostId(UUID postId) {
        var optionalResult = postDetailRepository.findPostDetailEntitiesByPostId(postId);
        return optionalResult.map(postDetailMapper::toTarget).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


}
