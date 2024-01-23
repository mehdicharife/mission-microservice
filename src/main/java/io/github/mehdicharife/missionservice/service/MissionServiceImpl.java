package io.github.mehdicharife.missionservice.service;

import java.util.List;

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
        return missionRepository.findById(id).get();
    }

    
    public Mission addMission(Mission mission) {
        return this.missionRepository.save(mission);
    }

    public List<Mission> getAllMissions() {
        return this.missionRepository.findAll();
    }
}
