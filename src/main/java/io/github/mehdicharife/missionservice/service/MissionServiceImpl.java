package io.github.mehdicharife.missionservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import io.github.mehdicharife.missionservice.domain.Mission;
import io.github.mehdicharife.missionservice.repository.MissionRepository;
import jakarta.annotation.PostConstruct;


@Service
public class MissionServiceImpl implements MissionService {

    List<Mission> missions = new ArrayList<>();

    @PostConstruct
    public void init() {
        missions.add(new Mission(1L, "Mission 1", "Description for Mission 1"));
        missions.add(new Mission(2L, "Mission 2", "Description for Mission 2"));
        missions.add(new Mission(3L, "Mission 3", "Description for Mission 3"));
        missions.add(new Mission(4L, "Mission 4", "Description for Mission 4"));
        missions.add(new Mission(5L, "Mission 5", "Description for Mission 5"));
    }

    private MissionRepository missionRepository;

    private Mission mission;

    public MissionServiceImpl(MissionRepository missionRepository) {
        this.missionRepository = missionRepository;
        mission = new Mission((long) 1, "some mission", "some mission description");
    }
    
    public Mission getMissionById(Long id) {
        return mission;
        //return this.missionRepository.getById(id);
    }

    
    public Mission addMission(Mission mission) {
        return this.missionRepository.save(mission);
    }

    public List<Mission> getAllMissions() {
        return missions;
        //return this.missionRepository.findAll();
    }
}
