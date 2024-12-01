package com.tutorlink.matchmaking_domain.studentdomainmanager.service;


import com.tutorlink.matchmaking_domain.studentdomainmanager.model.dto.StudentProfileResp;
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
}

