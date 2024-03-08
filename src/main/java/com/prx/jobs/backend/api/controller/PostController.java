package com.prx.jobs.backend.api.controller;

import com.prx.jobs.backend.api.service.PostService;
import com.prx.jobs.backend.api.to.GetPostResponse;
import com.prx.jobs.backend.api.to.PostContentTO;
import jakarta.ws.rs.PathParam;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    /**
     * Finds post content by post id.
     *
     * @return ResponseEntity<List<PostContentTO>>.
     */
    @GetMapping(path = "/collection", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PostContentTO>> findPostContent() {
        return postService.findPostContent();
    }

    /**
     * Finds post content by post id.
     *
     * @param postId The post id.
     * @return ResponseEntity<GetPostResponse>.
     */
    @GetMapping()
    public ResponseEntity<GetPostResponse> findPostContentByPostId(@PathParam("postId") String postId) {
        return postService.findPostContentByPostId(UUID.fromString(postId));
    }
}
