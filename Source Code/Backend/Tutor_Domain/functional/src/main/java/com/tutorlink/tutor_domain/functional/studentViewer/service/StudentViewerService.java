package com.tutorlink.tutor_domain.functional.studentViewer.service;


import com.tutorlink.tutor_domain.functional.studentViewer.model.dto.resp.StudentProfileResp;
import com.tutorlink.tutor_domain.functional.studentViewer.model.proxy.MatchmakingStudentProxy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentViewerService {

    private final MatchmakingStudentProxy matchmakingStudentProxy;

    public StudentProfileResp getStudentProfile(Long studentId) {
        return matchmakingStudentProxy.fetchStudentProfile(studentId);
    }

    public List<StudentProfileResp> getAllStudentProfiles() {
        return matchmakingStudentProxy.fetchAllStudentProfiles();
    }
}

