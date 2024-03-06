package com.prx.jobs.backend.api.service;

import com.prx.jobs.backend.api.to.SourceListResponse;
import com.prx.jobs.backend.jpa.entity.SourceEntity;
import com.prx.jobs.backend.jpa.repository.SourceRepository;
import com.prx.jobs.backend.mapper.SourceMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * The SourceServiceImpl class is a Spring service component that implements the SourceService interface.
 * <p>
 * The SourceServiceImpl class provides methods for performing CRUD operations on the SourceEntity.
 */
@Service
public class SourceServiceImpl implements SourceService {

    /**
     * The SourceRepository is a Spring Data JPA repository interface that provides methods for performing CRUD operations on the SourceEntity.
     */
    private final SourceRepository sourceRepository;

    /**
     * The SourceMapper is a MapStruct mapper interface that provides methods for mapping between the SourceEntity and SourceTO.
     */
    private final SourceMapper sourceMapper;

    /**
     * Constructs a new SourceServiceImpl with the specified SourceRepository and SourceMapper.
     *
     * @param sourceRepository the SourceRepository
     * @param sourceMapper     the SourceMapper
     */
    public SourceServiceImpl(SourceRepository sourceRepository, SourceMapper sourceMapper) {
        this.sourceRepository = sourceRepository;
        this.sourceMapper = sourceMapper;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<SourceListResponse> list(boolean includeInactive) {
        List<SourceEntity> sourceEntities = includeInactive ? sourceRepository.findAll() :
                sourceRepository.findAllByActive(true)
                        .orElse(Collections.emptyList());
        return ResponseEntity.ok(new SourceListResponse(sourceMapper.toTarget(sourceEntities)));
    }
}
