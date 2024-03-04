package com.prx.jobs.backend.api.service;

import com.prx.jobs.backend.api.to.TermListResponse;
import com.prx.jobs.backend.jpa.entity.TermEntity;
import com.prx.jobs.backend.jpa.repository.TermRepository;
import com.prx.jobs.backend.mapper.TermMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * The TermServiceImpl class is a Spring service component that implements the TermService interface.
 * <p>
 * The TermServiceImpl class provides methods for performing CRUD operations on the TermEntity.
 */
@Service
public class TermServiceImpl implements TermService {

    /**
     * The TermRepository is a Spring Data JPA repository interface that provides methods for performing CRUD operations on the TermEntity.
     */
    private final TermRepository termRepository;
    /**
     * The TermMapper is a MapStruct mapper interface that provides methods for mapping between the TermEntity and TermTO.
     */
    private final TermMapper termMapper;

    /**
     * The TermServiceImpl constructor injects a TermRepository instance.
     *
     * @param termRepository The TermRepository instance.
     */
    public TermServiceImpl(TermRepository termRepository, TermMapper termMapper) {
        this.termRepository = termRepository;
        this.termMapper = termMapper;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<TermListResponse> list(boolean includeInactive) {
        List<TermEntity> termEntityList = includeInactive ? termRepository.findAll() :
                termRepository.findAllByActive(true)
                        .orElse(Collections.emptyList());
        return ResponseEntity.ok(new TermListResponse(termMapper.toTarget(termEntityList)));
    }
}
