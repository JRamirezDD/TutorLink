package com.tutorlink.matchmaking_domain.studentdomainmanager.model.proxy;

import com.tutorlink.matchmaking_domain.studentdomainmanager.model.dto.req.UpdateStudentProfileReq;
import com.tutorlink.matchmaking_domain.studentdomainmanager.model.dto.resp.StudentProfileResp;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class StudentDomainProxy {

    private final RestTemplate restTemplate = new RestTemplate();

    @Value("https://localhost:10011")
    private String studentDomainUrl;

    public StudentProfileResp fetchStudentProfile(Long studentId) {
        String url = String.format("%s/profile/%d", studentDomainUrl, studentId);
        return restTemplate.getForObject(url, StudentProfileResp.class);
    }

    public StudentProfileResp updateStudentProfile(Long studentId, UpdateStudentProfileReq request) {
        String url = String.format("%s/profile/%d", studentDomainUrl, studentId);
        return restTemplate.exchange(url, HttpMethod.PUT, new HttpEntity<>(request), StudentProfileResp.class).getBody();
    }
}


