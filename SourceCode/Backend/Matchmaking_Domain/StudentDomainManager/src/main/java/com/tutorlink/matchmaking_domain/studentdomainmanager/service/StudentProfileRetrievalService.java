package com.tutorlink.matchmaking_domain.studentdomainmanager.service;

import com.tutorlink.matchmaking_domain.studentdomainmanager.model.dto.req.UpdateStudentProfileReq;
import com.tutorlink.matchmaking_domain.studentdomainmanager.model.dto.resp.StudentProfileResp;
import com.tutorlink.matchmaking_domain.studentdomainmanager.model.proxy.StudentDomainProxy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentProfileRetrievalService {

    private final StudentDomainProxy studentDomainProxy;

    public StudentProfileResp getStudentProfile(Long studentId) {
        return studentDomainProxy.fetchStudentProfile(studentId);
    }

    public StudentProfileResp updateStudentProfile(Long studentId, UpdateStudentProfileReq request) {
        return studentDomainProxy.updateStudentProfile(studentId, request);
    }
}


