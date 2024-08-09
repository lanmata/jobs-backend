package com.prx.jobs.backend.api.service;

import com.prx.jobs.backend.api.to.TermListResponse;
import com.prx.jobs.backend.api.to.TermTO;
import com.prx.jobs.backend.jpa.entity.TermEntity;
import com.prx.jobs.backend.jpa.repository.TermRepository;
import com.prx.jobs.backend.mapper.TermMapper;
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
class TermServiceImplTest {

    @InjectMocks
    private TermServiceImpl termService;

    @Mock
    private TermRepository termRepository;

    @Mock
    private TermMapper termMapper;

    @Test
    void listShouldReturnAllTermWhenIncludeInactiveIsTrue() {
        var uuid = UUID.randomUUID();
        var termEntity = new TermEntity();
        termEntity.setId(uuid);
        termEntity.setName("name");
        termEntity.setDescription("description");
        termEntity.setActive(true);
        List<TermEntity> allStatuses = Collections.singletonList(termEntity);
        List<TermTO> termTOS = Collections.singletonList(new TermTO(uuid, "name", "description", true));

        when(termRepository.findAll()).thenReturn(allStatuses);
        when(termMapper.toTarget(allStatuses)).thenReturn(termTOS);

        ResponseEntity<TermListResponse> response = termService.list(true);
        assertEquals(ResponseEntity.ok().body(new TermListResponse(termTOS)), response);
    }

    @Test
    void listShouldReturnActiveTermWhenIncludeInactiveIsFalse() {
        var uuid = UUID.randomUUID();
        var termEntity = new TermEntity();
        termEntity.setId(uuid);
        termEntity.setName("name");
        termEntity.setDescription("description");
        termEntity.setActive(true);
        List<TermEntity> termEntities = Collections.singletonList(termEntity);
        List<TermTO> termTOList = Collections.singletonList(new TermTO(uuid, "name", "description", true));

        when(termRepository.findAll()).thenReturn(termEntities);
        when(termMapper.toTarget(termEntities)).thenReturn(termTOList);

        ResponseEntity<TermListResponse> response = termService.list(true);
        assertEquals(ResponseEntity.ok().body(new TermListResponse(termTOList)), response);
    }

    @Test
    void listShouldReturnEmptyListWhenNoActiveTermsAndIncludeInactiveIsFalse() {
        when(termRepository.findAllByActive(true)).thenReturn(Optional.of(Collections.emptyList()));

        ResponseEntity<TermListResponse> response = termService.list(false);

        assertEquals(ResponseEntity.ok().body(new TermListResponse(Collections.emptyList())), response);
    }

}
