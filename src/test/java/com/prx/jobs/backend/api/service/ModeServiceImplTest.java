package com.prx.jobs.backend.api.service;

import com.prx.jobs.backend.api.to.ModeListResponse;
import com.prx.jobs.backend.api.to.ModeTO;
import com.prx.jobs.backend.api.to.StatusListResponse;
import com.prx.jobs.backend.api.to.StatusTO;
import com.prx.jobs.backend.jpa.entity.ModeEntity;
import com.prx.jobs.backend.jpa.entity.StatusEntity;
import com.prx.jobs.backend.jpa.repository.ModeRepository;
import com.prx.jobs.backend.mapper.ModeMapper;
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
class ModeServiceImplTest {

    @InjectMocks
    private ModeServiceImpl modeService;

    @Mock
    private ModeRepository modeRepository;

    @Mock
    private ModeMapper modeMappersMapper;

    @Test
    void listShouldReturnAllStatusesWhenIncludeInactiveIsTrue() {
        var uuid = UUID.randomUUID();
        var modeEntity = new ModeEntity();
        modeEntity.setId(uuid);
        modeEntity.setName("name");
        modeEntity.setDescription("description");
        modeEntity.setActive(true);
        List<ModeEntity> allStatuses = Collections.singletonList(modeEntity);
        List<ModeTO> modeTOList = Collections.singletonList(new ModeTO(uuid, "name", "description", true));

        when(modeRepository.findAll()).thenReturn(allStatuses);
        when(modeMappersMapper.toTarget(allStatuses)).thenReturn(modeTOList);

        ResponseEntity<ModeListResponse> response = modeService.list(true);
        assertEquals(ResponseEntity.ok().body(new ModeListResponse(modeTOList)), response);
    }

    @Test
    void listShouldReturnActiveStatusesWhenIncludeInactiveIsFalse() {
        var uuid = UUID.randomUUID();
        var statusEntity = new ModeEntity();
        statusEntity.setId(uuid);
        statusEntity.setName("name");
        statusEntity.setDescription("description");
        statusEntity.setActive(true);
        List<ModeEntity> modeEntityList = Collections.singletonList(statusEntity);
        List<ModeTO> modeTOList = Collections.singletonList(new ModeTO(uuid, "name", "description", true));

        when(modeRepository.findAll()).thenReturn(modeEntityList);
        when(modeMappersMapper.toTarget(modeEntityList)).thenReturn(modeTOList);

        ResponseEntity<ModeListResponse> response = modeService.list(true);
        assertEquals(ResponseEntity.ok().body(new ModeListResponse(modeTOList)), response);
    }

    @Test
    void listShouldReturnEmptyListWhenNoActiveStatusesAndIncludeInactiveIsFalse() {
        when(modeRepository.findAllByActive(true)).thenReturn(Optional.of(Collections.emptyList()));

        ResponseEntity<ModeListResponse> response = modeService.list(false);

        assertEquals(ResponseEntity.ok().body(new ModeListResponse(Collections.emptyList())), response);
    }

}
