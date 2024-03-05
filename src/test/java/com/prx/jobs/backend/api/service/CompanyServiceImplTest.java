package com.prx.jobs.backend.api.service;

import com.prx.jobs.backend.api.to.CompanyListResponse;
import com.prx.jobs.backend.api.to.CompanyTO;
import com.prx.jobs.backend.jpa.entity.CompanyEntity;
import com.prx.jobs.backend.jpa.repository.CompanyRepository;
import com.prx.jobs.backend.mapper.CompanyMapper;
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
class CompanyServiceImplTest {

    @InjectMocks
    private CompanyServiceImpl companyService;

    @Mock
    private CompanyRepository companyRepository;

    @Mock
    private CompanyMapper companyMapper;

    @Test
    void listShouldReturnAllStatusesWhenIncludeInactiveIsTrue() {
        var uuid = UUID.randomUUID();
        var companyEntity = new CompanyEntity();
        companyEntity.setId(uuid);
        companyEntity.setName("name");
        companyEntity.setDescription("description");
        companyEntity.setActive(true);
        List<CompanyEntity> companyEntityList = Collections.singletonList(companyEntity);
        List<CompanyTO> companyTOList = Collections.singletonList(new CompanyTO(uuid, "name", "description", true));

        when(companyRepository.findAll()).thenReturn(companyEntityList);
        when(companyMapper.toTarget(companyEntityList)).thenReturn(companyTOList);

        ResponseEntity<CompanyListResponse> response = companyService.list(true);
        assertEquals(ResponseEntity.ok().body(new CompanyListResponse(companyTOList)), response);
    }

    @Test
    void listShouldReturnActiveStatusesWhenIncludeInactiveIsFalse() {
        var uuid = UUID.randomUUID();
        var companyEntity = new CompanyEntity();
        companyEntity.setId(uuid);
        companyEntity.setName("name");
        companyEntity.setDescription("description");
        companyEntity.setActive(true);
        List<CompanyEntity> companyEntityList = Collections.singletonList(companyEntity);
        List<CompanyTO> companyTOList = Collections.singletonList(new CompanyTO(uuid, "name", "description", true));

        when(companyRepository.findAll()).thenReturn(companyEntityList);
        when(companyMapper.toTarget(companyEntityList)).thenReturn(companyTOList);

        ResponseEntity<CompanyListResponse> response = companyService.list(true);
        assertEquals(ResponseEntity.ok().body(new CompanyListResponse(companyTOList)), response);
    }

    @Test
    void listShouldReturnEmptyListWhenNoActiveStatusesAndIncludeInactiveIsFalse() {
        when(companyRepository.findAllByActive(true)).thenReturn(Optional.of(Collections.emptyList()));

        ResponseEntity<CompanyListResponse> response = companyService.list(false);

        assertEquals(ResponseEntity.ok().body(new CompanyListResponse(Collections.emptyList())), response);
    }

}
