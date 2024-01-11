package io.github.mehdicharife.missionservice.service;

import java.util.List;

import io.github.mehdicharife.missionservice.domain.Mission;

public interface MissionService {
    Mission getMissionById(Long id);
    Mission addMission(Mission mission);
    List<Mission> getAllMissions();
}
