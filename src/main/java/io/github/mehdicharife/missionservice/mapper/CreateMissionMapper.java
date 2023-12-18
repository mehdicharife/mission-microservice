package io.github.mehdicharife.missionservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import io.github.mehdicharife.missionservice.domain.Mission;
import io.spring.guides.gs_producing_web_service.CreateMissionRequest;
import io.spring.guides.gs_producing_web_service.CreateMissionResponse;

@Mapper
public interface CreateMissionMapper {
    CreateMissionMapper INSTANCE = Mappers.getMapper(CreateMissionMapper.class);

    Mission fromDto(CreateMissionRequest createMissionRequest);


    @Mapping(source="id", target="mission.id")
    @Mapping(source="professorId", target="mission.professorId")
    @Mapping(source="title", target="mission.title")
    @Mapping(source="description", target="mission.description")
    CreateMissionResponse toDto(Mission mission);
}
