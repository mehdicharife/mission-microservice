package io.github.mehdicharife.missionservice.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import io.github.mehdicharife.missionservice.domain.Mission;
import io.github.mehdicharife.missionservice.mapper.CreateMissionMapper;
import io.github.mehdicharife.missionservice.mapper.GetMissionMapper;
import io.github.mehdicharife.missionservice.mapper.MissionMissionMapper;
import io.github.mehdicharife.missionservice.service.MissionService;
import io.spring.guides.gs_producing_web_service.CreateMissionRequest;
import io.spring.guides.gs_producing_web_service.CreateMissionResponse;
import io.spring.guides.gs_producing_web_service.GetAllMissionsRequest;
import io.spring.guides.gs_producing_web_service.GetAllMissionsResponse;
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
        System.out.println(getMissionRequest);
        Mission mission = this.missionService.getMissionById(getMissionRequest.getId());
        return GetMissionMapper.INSTANCE.toDto(mission);
    }

    @PayloadRoot(namespace= NAMESPACE_URI, localPart="createMissionRequest")
    @ResponsePayload
    public CreateMissionResponse createMission(@RequestPayload CreateMissionRequest createMissionRequest) {
        Mission mission = CreateMissionMapper.INSTANCE.fromDto(createMissionRequest);
        this.missionService.addMission(mission);
        return CreateMissionMapper.INSTANCE.toDto(mission);
    }

    @PayloadRoot(namespace= NAMESPACE_URI, localPart="getAllMissionsRequest")
    @ResponsePayload
    public GetAllMissionsResponse getAllMissions(@RequestPayload GetAllMissionsRequest getAllMissionsRequest) {
        List<Mission> missions = this.missionService.getAllMissions();
        GetAllMissionsResponse response = new GetAllMissionsResponse();
        List<io.spring.guides.gs_producing_web_service.Mission> list = response.getMission();
        for(int k = 0; k < missions.size(); k++) {
            list.add(MissionMissionMapper.toDto(missions.get(k)));
        }
        
        return response;
    }
}
