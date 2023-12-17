package io.github.mehdicharife.missionservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.mehdicharife.missionservice.domain.Mission;

@Repository
public interface MissionRepository extends JpaRepository<Mission, Long> {
    
}
