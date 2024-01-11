package io.github.mehdicharife.missionservice.mapper;


public class MissionMissionMapper {

    public static io.spring.guides.gs_producing_web_service.Mission toDto(io.github.mehdicharife.missionservice.domain.Mission mission) {
        io.spring.guides.gs_producing_web_service.Mission dto = new io.spring.guides.gs_producing_web_service.Mission();
        dto.setId(mission.getId());
        dto.setDescription(mission.getDescription());
        dto.setTitle(mission.getTitle());

        return dto;
    }
    
}
