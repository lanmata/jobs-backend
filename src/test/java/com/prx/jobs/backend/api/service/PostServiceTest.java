package com.prx.jobs.backend.api.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class PostServiceTest {

    private final PostService postService = new PostService() {
    };

    @Test
    void testList() {
        assertThrows(UnsupportedOperationException.class, postService::findPostContent);
    }
}
