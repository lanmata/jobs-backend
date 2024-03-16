package com.prx.jobs.backend.api.service;

import com.prx.jobs.backend.api.to.PositionListResponse;
import com.prx.jobs.backend.api.to.PostPositionRequest;
import com.prx.jobs.backend.api.to.SimpleResponse;
import com.prx.jobs.backend.jpa.entity.PositionEntity;
import com.prx.jobs.backend.jpa.repository.PositionRepository;
import com.prx.jobs.backend.mapper.PositionMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * The PositionServiceImpl class is a Spring service component that implements the PositionService interface.
 * <p>
 * The PositionServiceImpl class provides methods for performing CRUD operations on the PositionEntity.
 */
@Service
public class PositionServiceImpl implements PositionService {

    /**
     * The PositionRepository is a Spring Data JPA repository interface that provides methods for performing CRUD operations on the PositionEntity.
     */
    private final PositionRepository positionRepository;

    /**
     * The PositionMapper is a MapStruct mapper interface that provides methods for mapping between the PositionEntity and PositionTO.
     */
    private final PositionMapper positionMapper;

    /**
     * Constructs a new PositionServiceImpl with the specified PositionRepository and PositionMapper.
     *
     * @param positionRepository the PositionRepository
     * @param positionMapper     the PositionMapper
     */
    public PositionServiceImpl(PositionRepository positionRepository, PositionMapper positionMapper) {
        this.positionRepository = positionRepository;
        this.positionMapper = positionMapper;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<PositionListResponse> list(boolean includeInactive) {
        List<PositionEntity> positionEntityList = includeInactive ? positionRepository.findAll() :
                positionRepository.findAllByActive(true)
                        .orElse(Collections.emptyList());
        return ResponseEntity.ok(new PositionListResponse(positionMapper.toTarget(positionEntityList)));
    }

    @Override
    public ResponseEntity<SimpleResponse> save(PostPositionRequest request) {
        Objects.requireNonNull(request, "PostPositionRequest is required");
        Objects.requireNonNull(request.name(), "Position name is required");
        Objects.requireNonNull(request.description(), "Position description is required");
        Objects.requireNonNull(request.active(), "Position active status is required");
        PositionEntity positionEntity = positionMapper.toSource(request);
        positionRepository.save(positionEntity);
        return ResponseEntity.status(HttpStatus.CREATED).
                body(new SimpleResponse(positionEntity.getId(), null,
                        "Position created successfully"));
    }
}
