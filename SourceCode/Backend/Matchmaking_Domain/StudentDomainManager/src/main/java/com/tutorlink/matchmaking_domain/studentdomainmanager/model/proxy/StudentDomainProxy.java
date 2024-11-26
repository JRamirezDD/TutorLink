package com.tutorlink.matchmaking_domain.studentdomainmanager.model.proxy;

import com.tutorlink.matchmaking_domain.studentdomainmanager.model.dto.StudentProfileResp;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class StudentDomainProxy {

    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${student.domain.url}")
    private String studentDomainUrl;

    public StudentProfileResp fetchStudentProfile(Long studentId) {
        String url = String.format("%s/profile/%d", studentDomainUrl, studentId);
        return restTemplate.getForObject(url, StudentProfileResp.class);
    }
}

