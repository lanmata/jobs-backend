package com.prx.jobs.backend.api.controller;

import com.prx.jobs.backend.api.service.PostService;
import com.prx.jobs.backend.api.to.PostContentTO;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/v1/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/{postId}/content")
    public ResponseEntity<PostContentTO> findPostContentByPostId(@NotNull @PathVariable UUID postId) {
        return postService.findPostContentByPostId(postId);
    }
}
