package com.prx.jobs.backend.api.service;

import com.prx.jobs.backend.api.to.PostDetailTO;
import com.prx.jobs.backend.jpa.entity.PostDetailEntity;
import com.prx.jobs.backend.jpa.entity.PostEntity;
import com.prx.jobs.backend.jpa.entity.StatusEntity;
import com.prx.jobs.backend.jpa.repository.PostDetailRepository;
import com.prx.jobs.backend.mapper.PostDetailMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

class PostDetailServiceImplTest {

    @Mock
    private PostDetailRepository postDetailRepository;

    @Mock
    private PostDetailMapper postDetailMapper;

    @InjectMocks
    private PostDetailServiceImpl postDetailService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldReturnPostDetailsWhenPostExists() {
        UUID postId = UUID.randomUUID();
        var postDetailEntity = new PostDetailEntity();
        var postEntity = new PostEntity();
        var statusEntity = new StatusEntity();
        statusEntity.setId(UUID.randomUUID());
        postEntity.setId(postId);
        postDetailEntity.setPost(postEntity);
        postDetailEntity.setDescription("content");
        postDetailEntity.setDatetime(LocalDateTime.now());
        postDetailEntity.setMountRate(BigDecimal.ONE);
        postDetailEntity.setStatus(statusEntity);
        PostDetailTO postDetailTO = new PostDetailTO(UUID.randomUUID(), "content",
                LocalDateTime.now(), BigDecimal.ONE, postId, UUID.randomUUID());
        when(postDetailRepository.findPostDetailEntitiesByPostId(postId)).thenReturn(Optional.of(Collections.singletonList(postDetailEntity)));
        when(postDetailMapper.toTarget(Collections.singletonList(postDetailEntity))).thenReturn(Collections.singletonList(postDetailTO));

        ResponseEntity<List<PostDetailTO>> response = postDetailService.findPostDetailByPostId(postId);

        assertEquals(ResponseEntity.ok(Collections.singletonList(postDetailTO)), response);
    }

    @Test
    void shouldReturnNotFoundWhenPostDoesNotExist() {
        UUID postId = UUID.randomUUID();
        when(postDetailRepository.findPostDetailEntitiesByPostId(postId)).thenReturn(Optional.empty());

        ResponseEntity<List<PostDetailTO>> response = postDetailService.findPostDetailByPostId(postId);

        assertTrue(response.getStatusCode().is4xxClientError());
    }
}
