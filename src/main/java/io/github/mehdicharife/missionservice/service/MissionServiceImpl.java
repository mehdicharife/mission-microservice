package io.github.mehdicharife.missionservice.service;

import org.springframework.stereotype.Service;

import io.github.mehdicharife.missionservice.domain.Mission;
import io.github.mehdicharife.missionservice.repository.MissionRepository;


@Service
public class MissionServiceImpl implements MissionService {

    private MissionRepository missionRepository;

    public MissionServiceImpl(MissionRepository missionRepository) {
        this.missionRepository = missionRepository;
    }
    
    public Mission getMissionById(Long id) {
        return this.missionRepository.getById(id);
    }

    
    public Mission addMission(Mission mission) {
        return this.missionRepository.save(mission);
    }
}
