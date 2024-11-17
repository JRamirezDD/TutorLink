package com.tutorlink.student_domain.functional.service;

import com.tutorlink.student_domain.functional.model.dto.response.TutorProfileResp;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TutorViewerService {

    // Contacts Matchmaking Domain via Internal Proxy Pattern
    public List<TutorProfileResp> getAllTutors() {
        return null;
    }

    public TutorProfileResp getTutorProfileById(Long studentId, Long tutorId) {
        return null;
    }
}

