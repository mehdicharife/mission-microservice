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
        missions.add(new Mission((long) 9, "Mission 1", "Description for Mission 1"));
        missions.add(new Mission((long) 3, "Mission 2", "Description for Mission 2"));
        missions.add(new Mission((long) 6, "Mission 3", "Description for Mission 3"));

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
        System.out.println(mission);
        return this.missionRepository.save(mission);
    }

    public List<Mission> getAllMissions() {
        return missions;
        //return this.missionRepository.findAll();
    }
}
