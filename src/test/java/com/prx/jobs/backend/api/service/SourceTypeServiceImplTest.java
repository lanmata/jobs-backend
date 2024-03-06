package com.prx.jobs.backend.api.service;

import com.prx.jobs.backend.api.to.SourceTypeListResponse;
import com.prx.jobs.backend.api.to.SourceTypeTO;
import com.prx.jobs.backend.api.to.StatusListResponse;
import com.prx.jobs.backend.api.to.StatusTO;
import com.prx.jobs.backend.jpa.entity.SourceTypeEntity;
import com.prx.jobs.backend.jpa.repository.SourceTypeRepository;
import com.prx.jobs.backend.mapper.SourceTypeMapper;
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
class SourceTypeServiceImplTest {

    @InjectMocks
    private SourceTypeServiceImpl sourceTypeService;

    @Mock
    private SourceTypeRepository sourceTypeRepository;

    @Mock
    private SourceTypeMapper sourceTypeMapper;

    @Test
    void listShouldReturnAllSourceTypesWhenIncludeInactiveIsTrue() {
        var uuid = UUID.randomUUID();
        var sourceTypeEntity = new SourceTypeEntity();
        sourceTypeEntity.setId(uuid);
        sourceTypeEntity.setName("name");
        sourceTypeEntity.setDescription("description");
        sourceTypeEntity.setActive(true);
        List<SourceTypeEntity> sourceTypeEntities = Collections.singletonList(sourceTypeEntity);
        List<SourceTypeTO> sourceTypeTOList = Collections.singletonList(new SourceTypeTO(uuid, "name", "description", true));

        when(sourceTypeRepository.findAll()).thenReturn(sourceTypeEntities);
        when(sourceTypeMapper.toTarget(sourceTypeEntities)).thenReturn(sourceTypeTOList);

        ResponseEntity<SourceTypeListResponse> response = sourceTypeService.list(true);
        assertEquals(ResponseEntity.ok().body(new SourceTypeListResponse(sourceTypeTOList)), response);
    }

    @Test
    void listShouldReturnActiveSourceTypeWhenIncludeInactiveIsFalse() {
        var uuid = UUID.randomUUID();
        var sourceTypeEntity = new SourceTypeEntity();
        sourceTypeEntity.setId(uuid);
        sourceTypeEntity.setName("name");
        sourceTypeEntity.setDescription("description");
        sourceTypeEntity.setActive(true);
        List<SourceTypeEntity> sourceTypeEntityList = Collections.singletonList(sourceTypeEntity);
        List<SourceTypeTO> sourceTypeTOList = Collections.singletonList(new SourceTypeTO(uuid, "name", "description", true));

        when(sourceTypeRepository.findAll()).thenReturn(sourceTypeEntityList);
        when(sourceTypeMapper.toTarget(sourceTypeEntityList)).thenReturn(sourceTypeTOList);

        ResponseEntity<SourceTypeListResponse> response = sourceTypeService.list(true);
        assertEquals(ResponseEntity.ok().body(new SourceTypeListResponse(sourceTypeTOList)), response);
    }

    @Test
    void listShouldReturnEmptyListWhenNoActiveSourceTypeAndIncludeInactiveIsFalse() {
        when(sourceTypeRepository.findAllByActive(true)).thenReturn(Optional.of(Collections.emptyList()));

        ResponseEntity<SourceTypeListResponse> response = sourceTypeService.list(false);

        assertEquals(ResponseEntity.ok().body(new SourceTypeListResponse(Collections.emptyList())), response);
    }

}
