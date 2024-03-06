package com.prx.jobs.backend.api.service;

import com.prx.jobs.backend.api.to.SourceTypeListResponse;
import com.prx.jobs.backend.jpa.entity.SourceTypeEntity;
import com.prx.jobs.backend.jpa.repository.SourceTypeRepository;
import com.prx.jobs.backend.mapper.SourceTypeMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * The SourceTypeServiceImpl class is a Spring service component that implements the SourceTypeService interface.
 * <p>
 * The SourceTypeServiceImpl class provides methods for performing CRUD operations on the SourceTypeEntity.
 */
@Service
public class SourceTypeServiceImpl implements SourceTypeService {

    /**
     * The SourceTypeRepository is a Spring Data JPA repository interface that provides methods for performing CRUD operations on the SourceTypeEntity.
     */
    private final SourceTypeRepository sourceTypeRepository;

    /**
     * The SourceTypeMapper is a MapStruct mapper interface that provides methods for mapping between the SourceTypeEntity and PositionTO.
     */
    private final SourceTypeMapper sourceTypeMapper;

    /**
     * Constructs a new SourceTypeServiceImpl with the specified SourceTypeRepository and SourceTypeMapper.
     *
     * @param sourceTypeRepository the SourceTypeRepository
     * @param sourceTypeMapper     the SourceTypeMapper
     */
    public SourceTypeServiceImpl(SourceTypeRepository sourceTypeRepository, SourceTypeMapper sourceTypeMapper) {
        this.sourceTypeRepository = sourceTypeRepository;
        this.sourceTypeMapper = sourceTypeMapper;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<SourceTypeListResponse> list(boolean includeInactive) {
        List<SourceTypeEntity> sourceTypeEntities = includeInactive ? sourceTypeRepository.findAll() :
                sourceTypeRepository.findAllByActive(true)
                        .orElse(Collections.emptyList());
        return ResponseEntity.ok(new SourceTypeListResponse(sourceTypeMapper.toTarget(sourceTypeEntities)));
    }
}
