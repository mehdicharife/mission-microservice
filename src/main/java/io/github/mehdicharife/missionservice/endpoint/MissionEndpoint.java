package io.github.mehdicharife.missionservice.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import io.github.mehdicharife.missionservice.domain.Mission;
import io.github.mehdicharife.missionservice.mapper.GetMissionMapper;
import io.github.mehdicharife.missionservice.service.MissionService;
import io.spring.guides.gs_producing_web_service.GetMissionRequest;
import io.spring.guides.gs_producing_web_service.GetMissionResponse;



@Endpoint
public class MissionEndpoint {
    
    private static final String NAMESPACE_URI="http://spring.io/guides/gs-producing-web-service";
    
    @Autowired
    private MissionService missionService;


    @PayloadRoot(namespace = NAMESPACE_URI, localPart="getMissionRequest")
    @ResponsePayload
    public GetMissionResponse getMission(@RequestPayload GetMissionRequest getMissionRequest) {
        Mission mission = this.missionService.getMissionById(getMissionRequest.getId());
        return GetMissionMapper.INSTANCE.toDto(mission);
    }
}
