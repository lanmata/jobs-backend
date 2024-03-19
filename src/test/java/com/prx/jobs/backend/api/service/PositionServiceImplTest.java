package com.prx.jobs.backend.api.service;

import com.prx.jobs.backend.api.to.PositionListResponse;
import com.prx.jobs.backend.api.to.PositionTO;
import com.prx.jobs.backend.api.to.PostPositionRequest;
import com.prx.jobs.backend.api.to.SimpleResponse;
import com.prx.jobs.backend.jpa.entity.PositionEntity;
import com.prx.jobs.backend.jpa.repository.PositionRepository;
import com.prx.jobs.backend.mapper.PositionMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class PositionServiceImplTest {

    @InjectMocks
    private PositionServiceImpl positionService;

    @Mock
    private PositionRepository positionRepository;

    @Mock
    private PositionMapper positionMapper;

    @Test
    @DisplayName("Test list method")
    void listShouldReturnAllPositionWhenIncludeInactiveIsTrue() {
        // Given
        var uuid = UUID.randomUUID();
        var positionEntity = new PositionEntity();
        positionEntity.setId(uuid);
        positionEntity.setName("name");
        positionEntity.setDescription("description");
        positionEntity.setActive(true);
        List<PositionEntity> positionEntityList = Collections.singletonList(positionEntity);
        List<PositionTO> positionTOList = Collections.singletonList(new PositionTO(uuid, "name", "description", true));

        // When
        when(positionRepository.findAll()).thenReturn(positionEntityList);
        when(positionMapper.toTarget(positionEntityList)).thenReturn(positionTOList);

        // Then
        ResponseEntity<PositionListResponse> response = positionService.list(true);
        assertEquals(ResponseEntity.ok().body(new PositionListResponse(positionTOList)), response);
    }

    @Test
    @DisplayName("Should return active position when includeInactive is false")
    void listShouldReturnActivePositionWhenIncludeInactiveIsFalse() {
        // Given
        var uuid = UUID.randomUUID();
        var positionEntity = new PositionEntity();
        positionEntity.setId(uuid);
        positionEntity.setName("name");
        positionEntity.setDescription("description");
        positionEntity.setActive(true);
        List<PositionEntity> positionEntityList = Collections.singletonList(positionEntity);
        List<PositionTO> positionTOList = Collections.singletonList(new PositionTO(uuid, "name", "description", true));
        //When
        when(positionRepository.findAll()).thenReturn(positionEntityList);
        when(positionMapper.toTarget(positionEntityList)).thenReturn(positionTOList);
        //Then
        ResponseEntity<PositionListResponse> response = positionService.list(true);
        assertEquals(ResponseEntity.ok().body(new PositionListResponse(positionTOList)), response);
    }

    @Test
    @DisplayName("Should return empty list when no active positions and includeInactive is false")
    void listShouldReturnEmptyListWhenNoActivePositionsAndIncludeInactiveIsFalse() {
        // When
        when(positionRepository.findAllByActive(true)).thenReturn(Optional.of(Collections.emptyList()));
        // Then
        ResponseEntity<PositionListResponse> response = positionService.list(false);
        assertEquals(ResponseEntity.ok().body(new PositionListResponse(Collections.emptyList())), response);
    }

    @Test
    @DisplayName("Should save position when all required fields are provided")
    void shouldSavePositionWhenAllRequiredFieldsAreProvided() {
        // Given
        PostPositionRequest request = new PostPositionRequest("Position1", "Description1", true);
        PositionEntity positionEntity = new PositionEntity();
        positionEntity.setId(UUID.randomUUID());
        positionEntity.setName("Position1");
        positionEntity.setDescription("Description1");
        positionEntity.setActive(true);
        // When
        when(positionMapper.toSource(request)).thenReturn(positionEntity);
        when(positionRepository.save(positionEntity)).thenReturn(positionEntity);
        // Then
        ResponseEntity<SimpleResponse> response = positionService.save(request);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("Position created successfully", response.getBody().message());
    }

    @Test
    @DisplayName("Should throw NullPointerException when request is null")
    void shouldThrowNullPointerExceptionWhenRequestIsNull() {
        assertThrows(NullPointerException.class, () -> positionService.save(null));
    }

    @Test
    @DisplayName("Should throw NullPointerException when position name is null")
    void shouldThrowNullPointerExceptionWhenPositionNameIsNull() {
        PostPositionRequest request = new PostPositionRequest(null, "Description1", true);
        assertThrows(NullPointerException.class, () -> positionService.save(request));
    }

    @Test
    @DisplayName("Should throw NullPointerException when position description is null")
    void shouldThrowNullPointerExceptionWhenPositionDescriptionIsNull() {
        PostPositionRequest request = new PostPositionRequest("Position1", null, true);
        assertThrows(NullPointerException.class, () -> positionService.save(request));
    }

    @Test
    @DisplayName("Should throw NullPointerException when position active status is null")
    void shouldThrowNullPointerExceptionWhenPositionActiveStatusIsNull() {
        PostPositionRequest request = new PostPositionRequest("Position1", "Description1", null);
        assertThrows(NullPointerException.class, () -> positionService.save(request));
    }

    @Test
    @DisplayName("Should save position when valid request is provided")
    void shouldSavePositionWhenValidRequestIsProvided() {
        PostPositionRequest request = new PostPositionRequest("name", "description", true);
        PositionEntity positionEntity = new PositionEntity();
        positionEntity.setId(UUID.randomUUID());

        when(positionMapper.toSource(request)).thenReturn(positionEntity);
        when(positionRepository.save(positionEntity)).thenReturn(positionEntity);

        ResponseEntity<SimpleResponse> response = positionService.save(request);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("Position created successfully", response.getBody().message());
    }

    @Test
    @DisplayName("Should return bad request when request is null")
    void shouldReturnBadRequestWhenRequestIsNull() {
        assertThrows(NullPointerException.class, () -> positionService.save(null));
    }

    @Test
    @DisplayName("Should return bad request when request fields are empty")
    void shouldReturnBadRequestWhenRequestFieldsAreEmpty() {
        var result1 = positionService.save(new PostPositionRequest("", "", true));
        var result2 = positionService.save(new PostPositionRequest("name", "", true));
        var result3 = positionService.save(new PostPositionRequest("", "description", true));
        assertEquals(HttpStatus.BAD_REQUEST, result1.getStatusCode());
        assertEquals(HttpStatus.BAD_REQUEST, result2.getStatusCode());
        assertEquals(HttpStatus.BAD_REQUEST, result3.getStatusCode());
    }

}
