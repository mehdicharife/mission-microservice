package io.github.mehdicharife.missionservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import io.github.mehdicharife.missionservice.domain.Mission;
import io.spring.guides.gs_producing_web_service.GetMissionResponse;


@Mapper
public interface GetMissionMapper {
    GetMissionMapper INSTANCE = Mappers.getMapper(GetMissionMapper.class);
    
    @Mapping(source="id", target="mission.id")
    @Mapping(source="title", target="mission.title")
    @Mapping(source="description", target="mission.description")
    GetMissionResponse toDto(Mission mission);


}
