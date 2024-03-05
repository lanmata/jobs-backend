package com.prx.jobs.backend.api.service;

import com.prx.jobs.backend.api.to.PositionListResponse;
import com.prx.jobs.backend.api.to.PositionTO;
import com.prx.jobs.backend.api.to.PositionListResponse;
import com.prx.jobs.backend.jpa.entity.PositionEntity;
import com.prx.jobs.backend.jpa.repository.PositionRepository;
import com.prx.jobs.backend.mapper.PositionMapper;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
    void listShouldReturnAllStatusesWhenIncludeInactiveIsTrue() {
        var uuid = UUID.randomUUID();
        var positionEntity = new PositionEntity();
        positionEntity.setId(uuid);
        positionEntity.setName("name");
        positionEntity.setDescription("description");
        positionEntity.setActive(true);
        List<PositionEntity> positionEntityList = Collections.singletonList(positionEntity);
        List<PositionTO> positionTOList = Collections.singletonList(new PositionTO(uuid, "name", "description", true));

        when(positionRepository.findAll()).thenReturn(positionEntityList);
        when(positionMapper.toTarget(positionEntityList)).thenReturn(positionTOList);

        ResponseEntity<PositionListResponse> response = positionService.list(true);
        assertEquals(ResponseEntity.ok().body(new PositionListResponse(positionTOList)), response);
    }

    @Test
    void listShouldReturnActiveStatusesWhenIncludeInactiveIsFalse() {
        var uuid = UUID.randomUUID();
        var positionEntity = new PositionEntity();
        positionEntity.setId(uuid);
        positionEntity.setName("name");
        positionEntity.setDescription("description");
        positionEntity.setActive(true);
        List<PositionEntity> positionEntityList = Collections.singletonList(positionEntity);
        List<PositionTO> positionTOList = Collections.singletonList(new PositionTO(uuid, "name", "description", true));

        when(positionRepository.findAll()).thenReturn(positionEntityList);
        when(positionMapper.toTarget(positionEntityList)).thenReturn(positionTOList);

        ResponseEntity<PositionListResponse> response = positionService.list(true);
        assertEquals(ResponseEntity.ok().body(new PositionListResponse(positionTOList)), response);
    }

    @Test
    void listShouldReturnEmptyListWhenNoActiveStatusesAndIncludeInactiveIsFalse() {
        when(positionRepository.findAllByActive(true)).thenReturn(Optional.of(Collections.emptyList()));

        ResponseEntity<PositionListResponse> response = positionService.list(false);

        assertEquals(ResponseEntity.ok().body(new PositionListResponse(Collections.emptyList())), response);
    }

}
