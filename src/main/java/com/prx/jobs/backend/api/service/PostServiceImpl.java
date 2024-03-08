package com.prx.jobs.backend.api.service;

import com.prx.jobs.backend.api.to.PostContentTO;
import com.prx.jobs.backend.jpa.repository.PostRepository;
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

    private final PostRepository postRepository;

    /**
     * Constructor
     *
     * @param postRepository The PostRepository object.
     */
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    /**{@inheritDoc}*/
    @Override
    public ResponseEntity<List<PostContentTO>> findPostContent() {
        var optionalResult = postRepository.findPostEntitiesByPostId();
        return optionalResult.map(objects -> ResponseEntity.ok(mapToObjectArrayToPostContentTO(objects.stream().toList()))).orElseGet(() -> ResponseEntity.notFound().build());
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
