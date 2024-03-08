package com.prx.jobs.backend.api.service;

import com.prx.jobs.backend.api.to.GetPostResponse;
import com.prx.jobs.backend.api.to.PostContentTO;
import com.prx.jobs.backend.jpa.repository.PostRepository;
import com.prx.jobs.backend.mapper.PostMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    /** The PostDetailService object. */
    private final PostDetailService postDetailService;
    /** The PostRepository object. */
    private final PostRepository postRepository;
    /** The PostMapper object. */
    private final PostMapper postMapper;

    /**
     * Constructor
     *
     * @param postRepository The PostRepository object.
     */
    public PostServiceImpl(PostRepository postRepository, PostDetailService postDetailService, PostMapper postMapper) {
        this.postRepository = postRepository;
        this.postDetailService = postDetailService;
        this.postMapper = postMapper;
    }

    /**{@inheritDoc}*/
    @Override
    public ResponseEntity<List<PostContentTO>> findPostContent() {
        var optionalResult = postRepository.findPostEntities();
        return optionalResult.map(objects -> ResponseEntity.ok(mapToObjectArrayToPostContentTO(objects.stream().toList()))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**{@inheritDoc}*/
    @Override
    public ResponseEntity<GetPostResponse> findPostContentByPostId(UUID uuid) {
        var optionalResult = postRepository.findById(uuid);
        GetPostResponse getPostResponse = null;
        if(optionalResult.isPresent()) {
            getPostResponse = postMapper.toTarget(optionalResult.get());
            getPostDetailByPostId(getPostResponse);
            return ResponseEntity.ok(getPostResponse);
        }
        return ResponseEntity.notFound().build();
    }

    private void getPostDetailByPostId(GetPostResponse getPostResponse) {
        postDetailService.findPostDetailTOByPostId(getPostResponse.id()).ifPresent(postDetailTOList -> getPostResponse.postDetailList().addAll(postDetailTOList));
    }

    /**
     * Maps a list of Object[][] to a list of PostContentTO.
     *
     * @param list List of Object[][].
     * @return List of PostContentTO.
     */
    private List<PostContentTO> mapToObjectArrayToPostContentTO(List<Object[][]> list) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S", Locale.ROOT);
        return list.stream().map(objects -> new PostContentTO(
                UUID.fromString(objects[0][0].toString()),
                new BigDecimal(objects[1][0].toString()),
                LocalDateTime.parse(objects[2][0].toString(), dateTimeFormatter),
                LocalDateTime.parse(objects[3][0].toString(), dateTimeFormatter),
                objects[4][0].toString(),
                objects[5][0].toString(),
                objects[6][0].toString(),
                objects[7][0].toString(),
                objects[8][0].toString(),
                objects[9][0].toString())).collect(Collectors.toCollection(ArrayList::new));
    }
}
