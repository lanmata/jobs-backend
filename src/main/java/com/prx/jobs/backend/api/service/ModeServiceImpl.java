package com.prx.jobs.backend.api.service;

import com.prx.jobs.backend.api.to.ModeListResponse;
import com.prx.jobs.backend.jpa.entity.ModeEntity;
import com.prx.jobs.backend.jpa.repository.ModeRepository;
import com.prx.jobs.backend.mapper.ModeMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * The ModeServiceImpl class is a Spring service component that implements the ModeService interface.
 * <p>
 * The ModeServiceImpl class provides methods for performing CRUD operations on the ModeEntity.
 */
@Service
public class ModeServiceImpl implements ModeService {

    /**
     * The ModeRepository is a Spring Data JPA repository interface that provides methods for performing CRUD operations on the ModeEntity.
     */
    private final ModeRepository modeRepository;
    /**
     * The ModeMapper is a MapStruct mapper interface that provides methods for mapping between the ModeEntity and ModeTO.
     */
    private final ModeMapper modeMapper;

    /**
     * Constructor
     *
     * @param modeRepository Mode Repository
     * @param modeMapper     Mode Mapper
     */
    public ModeServiceImpl(ModeRepository modeRepository, ModeMapper modeMapper) {
        this.modeRepository = modeRepository;
        this.modeMapper = modeMapper;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<ModeListResponse> list(boolean includeInactive) {
        List<ModeEntity> modeEntityList = includeInactive ? modeRepository.findAll() :
                modeRepository.findAllByActive(true)
                        .orElse(Collections.emptyList());
        return ResponseEntity.ok(new ModeListResponse(modeMapper.toTarget(modeEntityList)));
    }
}
