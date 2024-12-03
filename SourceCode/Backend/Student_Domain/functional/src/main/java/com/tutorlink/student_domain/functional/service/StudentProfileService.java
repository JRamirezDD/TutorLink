package com.tutorlink.student_domain.functional.service;

import com.tutorlink.matchmaking_domain.studentdomainmanager.model.dto.req.UpdateStudentProfileReq;
import com.tutorlink.matchmaking_domain.studentdomainmanager.model.dto.resp.StudentProfileResp;
import com.tutorlink.student_domain.functional.service.feignclients.Client_CrossDomainInteractions_StudentProfileRetrieval;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentProfileService {

    private final Client_CrossDomainInteractions_StudentProfileRetrieval profileManagementClient;

    public StudentProfileResp getStudentProfile(Long studentId) {
        return profileManagementClient.getStudentProfile(studentId).getBody();
    }

    public StudentProfileResp updateStudentProfile(Long studentId, UpdateStudentProfileReq request) {
        return profileManagementClient.updateStudentProfile(studentId, request).getBody();
    }
}




