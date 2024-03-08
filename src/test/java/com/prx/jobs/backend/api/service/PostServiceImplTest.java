package com.prx.jobs.backend.api.service;

import com.prx.jobs.backend.api.to.PostContentTO;
import com.prx.jobs.backend.jpa.repository.PostRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
    void findPostContentByPostIdReturnsOkWhenPostExists() {
        UUID postId = UUID.randomUUID();
        List<Object[][]> postEntities = new ArrayList<>();
        var objects = new Object[10][1];
        objects[0][0] = postId.toString();
        objects[1][0] = "100.00";
        objects[2][0] = "2022-01-01 00:00:00.0";
        objects[3][0] = "2022-01-01 00:00:00.0";
        objects[4][0] = "title";
        objects[5][0] = "description";
        objects[6][0] = "content";
        objects[7][0] = "author";
        objects[8][0] = "category";
        objects[9][0] = "tags";
        postEntities.add(objects);
        when(postRepository.findPostEntitiesByPostId()).thenReturn(Optional.of(postEntities));

        ResponseEntity<List<PostContentTO>> response = postService.findPostContent();

        assertTrue(response.getStatusCode().equals(HttpStatus.OK));
        assertTrue(!response.getBody().isEmpty()); // Assuming the mapping function is not yet implemented
    }

    @Test
    void findPostContentByPostIdReturnsNotFoundWhenPostDoesNotExist() {
        UUID postId = UUID.randomUUID();
        when(postRepository.findPostEntitiesByPostId()).thenReturn(Optional.empty());

        ResponseEntity<List<PostContentTO>> response = postService.findPostContent();

        assertTrue(response.getStatusCode().is4xxClientError());
    }
}
