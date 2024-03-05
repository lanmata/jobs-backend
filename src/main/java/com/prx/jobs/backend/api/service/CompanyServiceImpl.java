package com.prx.jobs.backend.api.service;

import com.prx.jobs.backend.api.to.CompanyListResponse;
import com.prx.jobs.backend.jpa.entity.CompanyEntity;
import com.prx.jobs.backend.jpa.repository.CompanyRepository;
import com.prx.jobs.backend.mapper.CompanyMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * The ModeServiceImpl class is a Spring service component that implements the CompanyService interface.
 * <p>
 * The CompanyServiceImpl class provides methods for performing CRUD operations on the CompanyEntity.
 */
@Service
public class CompanyServiceImpl implements CompanyService {

    /**
     * The CompanyRepository is a Spring Data JPA repository interface that provides methods for performing CRUD operations on the CompanyEntity.
     */
    private final CompanyRepository companyRepository;
    /**
     * The CompanyMapper is a MapStruct mapper interface that provides methods for mapping between the CompanyEntity and CompanyTO.
     */
    private final CompanyMapper companyMapper;

    /**
     * Constructs a new CompanyServiceImpl with the specified CompanyRepository and CompanyMapper.
     *
     * @param companyRepository the CompanyRepository
     * @param companyMapper     the CompanyMapper
     */
    public CompanyServiceImpl(CompanyRepository companyRepository, CompanyMapper companyMapper) {
        this.companyRepository = companyRepository;
        this.companyMapper = companyMapper;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<CompanyListResponse> list(boolean includeInactive) {
        List<CompanyEntity> companyEntityList = includeInactive ? companyRepository.findAll() :
                companyRepository.findAllByActive(true)
                        .orElse(Collections.emptyList());
        return ResponseEntity.ok(new CompanyListResponse(companyMapper.toTarget(companyEntityList)));
    }
}
