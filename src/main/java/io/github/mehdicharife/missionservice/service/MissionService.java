package io.github.mehdicharife.missionservice.service;

import io.github.mehdicharife.missionservice.domain.Mission;

public interface MissionService {
    Mission getMissionById(Long id);
}
