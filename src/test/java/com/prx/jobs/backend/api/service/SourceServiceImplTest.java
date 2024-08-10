package com.prx.jobs.backend.api.service;

import com.prx.jobs.backend.api.to.SourceListResponse;
import com.prx.jobs.backend.api.to.SourceTO;
import com.prx.jobs.backend.jpa.entity.SourceEntity;
import com.prx.jobs.backend.jpa.repository.SourceRepository;
import com.prx.jobs.backend.mapper.SourceMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(value = {SpringExtension.class})
class SourceServiceImplTest {

    @InjectMocks
    private SourceServiceImpl sourceService;

    @Mock
    private SourceRepository sourceRepository;

    @Mock
    private SourceMapper sourceMapper;

    @Test
    void listShouldReturnAllSourceWhenIncludeInactiveIsTrue() {
        var uuid = UUID.randomUUID();
        var sourceEntity = new SourceEntity();
        sourceEntity.setId(uuid);
        sourceEntity.setName("name");
        sourceEntity.setDescription("description");
        sourceEntity.setActive(true);
        List<SourceEntity> sourceTypeEntities = Collections.singletonList(sourceEntity);
        List<SourceTO> sourceTOList = Collections.singletonList(new SourceTO(uuid, "name", "description", true, UUID.randomUUID()));

        when(sourceRepository.findAll()).thenReturn(sourceTypeEntities);
        when(sourceMapper.toTarget(sourceTypeEntities)).thenReturn(sourceTOList);

        ResponseEntity<SourceListResponse> response = sourceService.list(true);
        assertEquals(ResponseEntity.ok().body(new SourceListResponse(sourceTOList)), response);
    }

    @Test
    void listShouldReturnActiveSourceWhenIncludeInactiveIsFalse() {
        var uuid = UUID.randomUUID();
        var sourceEntity = new SourceEntity();
        sourceEntity.setId(uuid);
        sourceEntity.setName("name");
        sourceEntity.setDescription("description");
        sourceEntity.setActive(true);
        List<SourceEntity> sourceEntityList = Collections.singletonList(sourceEntity);
        List<SourceTO> sourceTOList = Collections.singletonList(new SourceTO(uuid, "name", "description", true, UUID.randomUUID()));

        when(sourceRepository.findAll()).thenReturn(sourceEntityList);
        when(sourceMapper.toTarget(sourceEntityList)).thenReturn(sourceTOList);

        ResponseEntity<SourceListResponse> response = sourceService.list(true);
        assertEquals(ResponseEntity.ok().body(new SourceListResponse(sourceTOList)), response);
    }

    @Test
    void listShouldReturnEmptyListWhenNoActiveSourceAndIncludeInactiveIsFalse() {
        when(sourceRepository.findAllByActive(true)).thenReturn(Optional.of(Collections.emptyList()));

        ResponseEntity<SourceListResponse> response = sourceService.list(false);

        assertEquals(ResponseEntity.ok().body(new SourceListResponse(Collections.emptyList())), response);
    }

}
