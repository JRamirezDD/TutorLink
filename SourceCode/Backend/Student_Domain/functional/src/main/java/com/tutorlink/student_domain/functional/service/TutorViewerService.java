package com.tutorlink.student_domain.functional.service;

import com.tutorlink.matchmaking_domain.crossdomaininteractions.connection.model.dto.CreateConnectionRequest.req.CreateConnectionReq;
import com.tutorlink.matchmaking_domain.crossdomaininteractions.connection.model.dto.GetConnection.resp.ConnectionResp;
import com.tutorlink.matchmaking_domain.tutordomainmanager.tutorprofileretrieval.model.dto.resp.TutorProfileResp;
import com.tutorlink.student_domain.functional.service.feignclients.Client_TutorDomainManager_TutorView;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TutorViewerService {

    private final Client_TutorDomainManager_TutorView tutorViewClient;

    public List<com.tutorlink.matchmaking_domain.tutordomainmanager.tutorprofileretrieval.model.dto.resp.TutorProfileResp> getAllTutors() {
        ResponseEntity<List<com.tutorlink.matchmaking_domain.tutordomainmanager.tutorprofileretrieval.model.dto.resp.TutorProfileResp>> response = tutorViewClient
                .getAllTutorProfiles();
        return response.getBody();
    }

    public TutorProfileResp getTutorProfileById(Long tutorId) {
        ResponseEntity<com.tutorlink.matchmaking_domain.tutordomainmanager.tutorprofileretrieval.model.dto.resp.TutorProfileResp> response = tutorViewClient
                .getTutorProfile(tutorId);
        return response.getBody();
    }

    public ConnectionResp createConnection(CreateConnectionReq connectionReq) {
        // not 100% sure if this goes here, but I'm assuming students can also create
        // connections from tutor's profiles
        return null;
    }
}
