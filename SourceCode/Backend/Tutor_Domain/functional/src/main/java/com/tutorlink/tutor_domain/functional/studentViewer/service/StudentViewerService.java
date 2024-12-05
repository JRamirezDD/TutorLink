package com.tutorlink.tutor_domain.functional.studentViewer.service;

import com.tutorlink.matchmaking_domain.studentdomainmanager.model.dto.resp.StudentProfileResp;
import com.tutorlink.tutor_domain.functional.studentViewer.service.feignclient.Client_StudentProfileRetrieval;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentViewerService {

    private final Client_StudentProfileRetrieval studentProfileClient;

    public StudentProfileResp getStudentProfile(Long studentId) {
        return studentProfileClient.getStudentProfile(studentId).getBody();
    }
}
