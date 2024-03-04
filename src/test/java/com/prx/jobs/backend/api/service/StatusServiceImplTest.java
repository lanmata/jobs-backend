package com.prx.jobs.backend.api.service;

import com.prx.jobs.backend.api.to.StatusListResponse;
import com.prx.jobs.backend.api.to.StatusTO;
import com.prx.jobs.backend.jpa.entity.StatusEntity;
import com.prx.jobs.backend.jpa.repository.StatusRepository;
import com.prx.jobs.backend.mapper.StatusMapper;
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
class StatusServiceImplTest {

    @InjectMocks
    private StatusServiceImpl statusService;

    @Mock
    private StatusRepository statusRepository;

    @Mock
    private StatusMapper statusMapper;

    @Test
    void listShouldReturnAllStatusesWhenIncludeInactiveIsTrue() {
        var uuid = UUID.randomUUID();
        var statusEntity = new StatusEntity();
        statusEntity.setId(uuid);
        statusEntity.setName("name");
        statusEntity.setDescription("description");
        statusEntity.setActive(true);
        List<StatusEntity> allStatuses = Collections.singletonList(statusEntity);
        List<StatusTO> allStatusesTO = Collections.singletonList(new StatusTO(uuid, "name", "description", true));

        when(statusRepository.findAll()).thenReturn(allStatuses);
        when(statusMapper.toTarget(allStatuses)).thenReturn(allStatusesTO);

        ResponseEntity<StatusListResponse> response = statusService.list(true);
        assertEquals(ResponseEntity.ok().body(new StatusListResponse(allStatusesTO)), response);
    }

    @Test
    void listShouldReturnActiveStatusesWhenIncludeInactiveIsFalse() {
        var uuid = UUID.randomUUID();
        var statusEntity = new StatusEntity();
        statusEntity.setId(uuid);
        statusEntity.setName("name");
        statusEntity.setDescription("description");
        statusEntity.setActive(true);
        List<StatusEntity> allStatuses = Collections.singletonList(statusEntity);
        List<StatusTO> allStatusesTO = Collections.singletonList(new StatusTO(uuid, "name", "description", true));

        when(statusRepository.findAll()).thenReturn(allStatuses);
        when(statusMapper.toTarget(allStatuses)).thenReturn(allStatusesTO);

        ResponseEntity<StatusListResponse> response = statusService.list(true);
        assertEquals(ResponseEntity.ok().body(new StatusListResponse(allStatusesTO)), response);
    }

    @Test
    void listShouldReturnEmptyListWhenNoActiveStatusesAndIncludeInactiveIsFalse() {
        when(statusRepository.findAllByActive(true)).thenReturn(Optional.of(Collections.emptyList()));

        ResponseEntity<StatusListResponse> response = statusService.list(false);

        assertEquals(ResponseEntity.ok().body(new StatusListResponse(Collections.emptyList())), response);
    }

}
