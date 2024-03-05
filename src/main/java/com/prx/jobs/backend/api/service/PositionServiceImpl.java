package com.prx.jobs.backend.api.service;

import com.prx.jobs.backend.api.to.PositionListResponse;
import com.prx.jobs.backend.api.to.TermListResponse;
import com.prx.jobs.backend.jpa.entity.PositionEntity;
import com.prx.jobs.backend.jpa.entity.TermEntity;
import com.prx.jobs.backend.jpa.repository.PositionRepository;
import com.prx.jobs.backend.jpa.repository.TermRepository;
import com.prx.jobs.backend.mapper.PositionMapper;
import com.prx.jobs.backend.mapper.TermMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

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
     * The PositionServiceImpl constructor injects a PositionRepository instance.
     *
     * @param positionRepository The PositionRepository instance.
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
}
