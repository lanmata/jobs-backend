package com.prx.jobs.backend.api.service;

import com.prx.jobs.backend.api.to.PostContentTO;
import com.prx.jobs.backend.jpa.repository.PostRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.UUID;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;


    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public ResponseEntity<PostContentTO> findPostContentByPostId(UUID postId) {
        var optionalResult = postRepository.findPostEntitiesByPostId(postId);
        return optionalResult.map(objects -> ResponseEntity.ok(mapToObjectArrayToPostContentTO(objects[0]))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    private PostContentTO mapToObjectArrayToPostContentTO(Object... result) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S", Locale.ROOT);
        return new PostContentTO(
                UUID.fromString(result[0].toString()),
                new BigDecimal(result[1].toString()),
                LocalDateTime.parse(result[2].toString(), dateTimeFormatter),
                LocalDateTime.parse(result[3].toString(), dateTimeFormatter),
                result[4].toString(),
                result[5].toString(),
                result[6].toString(),
                result[7].toString(),
                result[8].toString(),
                result[9].toString()
        );
    }
}
