package com.prx.jobs.backend.api.service;

import com.prx.jobs.backend.api.to.PostContentTO;
import com.prx.jobs.backend.jpa.repository.PostRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

class PostServiceImplTest {

    private PostServiceImpl postService;
    private PostRepository postRepository;

    @BeforeEach
    void setUp() {
        postRepository = Mockito.mock(PostRepository.class);
        postService = new PostServiceImpl(postRepository);
    }

    @Test
    void findPostContentByPostIdReturnsContentWhenPostExists() {
        UUID postId = UUID.randomUUID();
        Object[] postContent = new Object[]{
                postId.toString(),
                "100.00",
                "2022-01-01 00:00:00.0",
                "2022-01-01 00:00:00.0",
                "title",
                "description",
                "content",
                "author",
                "category",
                "tags"
        };
        when(postRepository.findPostEntitiesByPostId(postId)).thenReturn(Optional.of(new Object[][]{postContent}));

        ResponseEntity<PostContentTO> response = postService.findPostContentByPostId(postId);

        assertTrue(response.getStatusCode().is2xxSuccessful());
        assertEquals(postId, response.getBody().id());
    }

    @Test
    void findPostContentByPostIdReturnsNotFoundWhenPostDoesNotExist() {
        UUID postId = UUID.randomUUID();
        when(postRepository.findPostEntitiesByPostId(postId)).thenReturn(Optional.empty());

        ResponseEntity<PostContentTO> response = postService.findPostContentByPostId(postId);

        assertTrue(response.getStatusCode().is4xxClientError());
    }
}
