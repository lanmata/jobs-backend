package com.prx.jobs.backend.api.service;

import com.prx.jobs.backend.api.to.GetPostResponse;
import com.prx.jobs.backend.api.to.PostContentTO;
import com.prx.jobs.backend.jpa.entity.*;
import com.prx.jobs.backend.jpa.repository.PostRepository;
import com.prx.jobs.backend.mapper.PostMapper;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@SpringBootTest
class PostServiceImplTest {

    @InjectMocks
    private PostServiceImpl postService;
    @Mock
    private PostDetailServiceImpl postDetailService;
    @Mock
    private PostRepository postRepository;
    @Mock
    private PostMapper postMapper;

    @Test
    void findPostReturnsOkWhenPostExists() {
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
        when(postRepository.findPostEntities()).thenReturn(Optional.of(postEntities));

        ResponseEntity<List<PostContentTO>> response = postService.findPostContent();

        assertTrue(response.getStatusCode().equals(HttpStatus.OK));
        assertTrue(!response.getBody().isEmpty()); // Assuming the mapping function is not yet implemented
    }

    @Test
    void findPostContentReturnsNotFoundWhenPostDoesNotExist() {
        UUID postId = UUID.randomUUID();
        when(postRepository.findPostEntities()).thenReturn(Optional.empty());

        ResponseEntity<List<PostContentTO>> response = postService.findPostContent();

        assertTrue(response.getStatusCode().is4xxClientError());
    }

    @Test
    void findPostContentByPostIdReturnsPostContentWhenPostExists() {
        UUID uuid = UUID.randomUUID();
        var companyEntity = new CompanyEntity();
        var positionEntity = new PositionEntity();
        var termEntity = new TermEntity();
        var modeEntity = new ModeEntity();
        var sourceEntity = new SourceEntity();
        positionEntity.setId(UUID.randomUUID());
        positionEntity.setName("position");
        termEntity.setId(UUID.randomUUID());
        termEntity.setName("term");
        modeEntity.setId(UUID.randomUUID());
        modeEntity.setName("mode");
        sourceEntity.setId(UUID.randomUUID());
        sourceEntity.setName("source");

        GetPostResponse getPostResponse = new GetPostResponse(
                uuid,
                "Title",
                "Description",
                "reference",
                companyEntity.getId(),
                companyEntity.getName(),
                positionEntity.getId(),
                positionEntity.getName(),
                termEntity.getId(),
                termEntity.getName(),
                modeEntity.getId(),
                modeEntity.getName(),
                sourceEntity.getId(),
                sourceEntity.getName(),
                new ArrayList<>()
        );
        PostEntity postEntity = new PostEntity();
        postEntity.setId(uuid);
        postEntity.setTitle("Title");
        postEntity.setDescription("Description");
        postEntity.setReference("reference");

        when(postRepository.findById(uuid)).thenReturn(Optional.of(postEntity));
        when(postDetailService.findPostDetailTOByPostId(uuid)).thenReturn(Optional.of(new ArrayList<>()));
        when(postMapper.toTarget(Mockito.any(PostEntity.class))).thenReturn(getPostResponse);

        ResponseEntity<GetPostResponse> response = postService.findPostContentByPostId(uuid);

        assertEquals(ResponseEntity.ok(getPostResponse), response);
    }

    @Test
    void findPostContentByPostIdReturnsNotFoundWhenPostDoesNotExist() {
        UUID uuid = UUID.randomUUID();
        when(postRepository.findById(uuid)).thenReturn(Optional.empty());

        ResponseEntity<GetPostResponse> response = postService.findPostContentByPostId(uuid);

        assertEquals(ResponseEntity.notFound().build(), response);
    }
}
