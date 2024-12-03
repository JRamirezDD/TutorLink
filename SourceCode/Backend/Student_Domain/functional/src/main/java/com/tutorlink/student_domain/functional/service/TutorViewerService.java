package com.tutorlink.student_domain.functional.service;

import com.tutorlink.matchmaking_domain.crossdomaininteractions.connection.model.dto.CreateConnectionRequest.req.CreateConnectionReq;
import com.tutorlink.matchmaking_domain.crossdomaininteractions.connection.model.dto.GetConnection.resp.ConnectionResp;
import com.tutorlink.student_domain.functional.model.dto.response.TutorProfileResp;
import com.tutorlink.student_domain.functional.service.feignclients.Client_StudentDomainManager_Connection;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TutorViewerService {
    private final Client_StudentDomainManager_Connection client_StudentDomainManager;

    public List<TutorProfileResp> getAllTutors() {
        return null;
    }

    public TutorProfileResp getTutorProfileById(Long studentId, Long tutorId) {
        return null;
    }

    public ConnectionResp createConnection(CreateConnectionReq connectionReq) {
        ResponseEntity<ConnectionResp> response = client_StudentDomainManager.createConnection(connectionReq);
        if (response.getStatusCode() == HttpStatus.CREATED) {
            return response.getBody();
        }
        return null;
    }
}
