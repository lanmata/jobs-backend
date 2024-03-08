package com.prx.jobs.backend.api.service;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertThrows;

class PostDetailServiceTest {

    private final PostDetailService postDetailService = new PostDetailService() {
    };

    @Test
    void testList() {
        assertThrows(UnsupportedOperationException.class, () -> postDetailService.findPostDetailByPostId(UUID.randomUUID()));
    }

}
