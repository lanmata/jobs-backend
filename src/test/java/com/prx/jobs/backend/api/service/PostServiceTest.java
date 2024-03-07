package com.prx.jobs.backend.api.service;

import com.prx.jobs.backend.api.to.PostContentTO;
import com.prx.jobs.backend.jpa.repository.PostRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class PostServiceTest {

    @InjectMocks
    private PostServiceImpl postService;

    @Mock
    private PostRepository postRepository;

    @Test
    void shouldReturnPostContentWhenPostIdExists() {
        UUID postId = UUID.randomUUID();
        PostContentTO postContentTO = new PostContentTO(postId,
                new BigDecimal("100.00"),
                LocalDateTime.parse("2022-01-01 00:00:00.0", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S", Locale.ROOT)),
                LocalDateTime.parse("2022-01-01 00:00:00.0", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S", Locale.ROOT)),
                "title",
                "description",
                "content",
                "author",
                "category",
                "tags");
        Object[][] postContent = new Object[][]{
                new Object[]{
                        postId,
                        "100.00",
                        "2022-01-01 00:00:00.0",
                        "2022-01-01 00:00:00.0",
                        "title",
                        "description",
                        "content",
                        "author",
                        "category",
                        "tags"
                }
        };
        when(postRepository.findPostEntitiesByPostId(postId)).thenReturn(java.util.Optional.of(postContent));
        ResponseEntity<PostContentTO> response = postService.findPostContentByPostId(postId);

        assertNotNull(response);
        assertEquals(200, response.getStatusCode().value());
        assertEquals(postContentTO, response.getBody());
    }

    @Test
    void shouldThrowExceptionWhenPostIdDoesNotExist() {
        UUID postId = UUID.randomUUID();
        when(postService.findPostContentByPostId(postId)).thenThrow(new UnsupportedOperationException("Not implemented yet"));

        assertThrows(UnsupportedOperationException.class, () -> postService.findPostContentByPostId(postId));
    }
}
