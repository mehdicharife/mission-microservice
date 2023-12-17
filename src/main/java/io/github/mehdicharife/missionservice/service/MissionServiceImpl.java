package io.github.mehdicharife.missionservice.service;

import org.springframework.stereotype.Service;

import io.github.mehdicharife.missionservice.domain.Mission;
import jakarta.annotation.PostConstruct;


@Service
public class MissionServiceImpl implements MissionService {

    private static Mission mission;

    @PostConstruct
    public void init() {
        mission = new Mission();
        mission.setId(Long.valueOf(2632));
        mission.setDescription("some description");
        mission.setTitle("mission title");
    }
    
    public Mission getMissionById(Long id) {
        return mission;
    }
}
