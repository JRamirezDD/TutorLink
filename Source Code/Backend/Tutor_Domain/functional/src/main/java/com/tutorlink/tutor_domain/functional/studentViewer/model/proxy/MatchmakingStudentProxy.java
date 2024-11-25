package com.tutorlink.tutor_domain.functional.studentViewer.model.proxy;

import com.tutorlink.tutor_domain.functional.studentViewer.model.dto.resp.StudentProfileResp;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class MatchmakingStudentProxy {

    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${matchmaking.domain.url}")
    private String matchmakingDomainUrl;

    public StudentProfileResp fetchStudentProfile(Long studentId) {
        String url = String.format("%s/student-manager/profile/%d", matchmakingDomainUrl, studentId);
        return restTemplate.getForObject(url, StudentProfileResp.class);
    }

    public List<StudentProfileResp> fetchAllStudentProfiles() {
        String url = String.format("%s/student-manager/profiles", matchmakingDomainUrl);
        return List.of(restTemplate.getForObject(url, StudentProfileResp[].class));
    }
}

