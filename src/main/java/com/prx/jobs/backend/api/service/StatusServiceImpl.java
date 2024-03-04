package com.prx.jobs.backend.api.service;

import com.prx.jobs.backend.api.to.StatusListResponse;
import com.prx.jobs.backend.jpa.entity.StatusEntity;
import com.prx.jobs.backend.jpa.repository.StatusRepository;
import com.prx.jobs.backend.mapper.StatusMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * The StatusServiceImpl class is a Spring service component that implements the StatusService interface.
 * <p>
 * The StatusServiceImpl class provides methods for performing CRUD operations on the StatusEntity.
 */
@Service
public class StatusServiceImpl implements StatusService {

    /**
     * The StatusRepository is a Spring Data JPA repository interface that provides methods for performing CRUD operations on the StatusEntity.
     */
    private final StatusRepository statusRepository;
    /**
     * The StatusMapper is a MapStruct mapper interface that provides methods for mapping between the StatusEntity and StatusTO.
     */
    private final StatusMapper statusMapper;

    /**
     * The StatusServiceImpl constructor injects a StatusRepository instance.
     *
     * @param statusRepository The StatusRepository instance.
     */
    public StatusServiceImpl(StatusRepository statusRepository, StatusMapper statusMapper) {
        this.statusRepository = statusRepository;
        this.statusMapper = statusMapper;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<StatusListResponse> list(boolean includeInactive) {
        List<StatusEntity> statusList = includeInactive ? statusRepository.findAll() :
                statusRepository.findAllByActive(true)
                        .orElse(Collections.emptyList());
        return ResponseEntity.ok(new StatusListResponse(statusMapper.toTarget(statusList)));
    }
}
