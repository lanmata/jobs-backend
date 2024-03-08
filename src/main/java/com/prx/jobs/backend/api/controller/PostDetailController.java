package com.prx.jobs.backend.api.controller;

import com.prx.jobs.backend.api.service.PostDetailService;
import com.prx.jobs.backend.api.to.PostDetailTO;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.PathParam;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

/**
 * The PostDetailController class.
 */
@RestController
@RequestMapping("/v1/post-details")
public class PostDetailController {

    /**
     * The PostDetailService object.
     */
    private final PostDetailService postDetailService;

    /**
     * Constructor
     *
     * @param postDetailService The PostDetailService object.
     */
    public PostDetailController(PostDetailService postDetailService) {
        this.postDetailService = postDetailService;
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<PostDetailTO>> findPostDetailByPostId(@PathParam(value = "postId") @NotNull @org.hibernate.validator.constraints.UUID String postId) {
        return postDetailService.findPostDetailByPostId(UUID.fromString(postId));
    }

}
