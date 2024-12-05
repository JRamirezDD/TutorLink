package com.tutorlink.student_domain.functional.service;

import com.tutorlink.student_domain.functional.model.dto.request.CreateStudentProfileReq;
import com.tutorlink.student_domain.functional.model.dto.request.UpdateStudentProfileReq;
import com.tutorlink.student_domain.functional.model.dto.response.StudentProfileResp;
import com.tutorlink.student_domain.functional.model.entity.StudentProfile;
import com.tutorlink.student_domain.functional.repository.StudentProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentProfileService {

    private final StudentProfileRepository studentProfileRepository;

    public StudentProfileResp getStudentProfile(Long studentId) {
        StudentProfile profile = studentProfileRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student profile not found"));

        return mapToStudentProfileResp(profile);
    }

    public StudentProfileResp updateStudentProfile(Long studentId, UpdateStudentProfileReq request) {
        StudentProfile profile = studentProfileRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student profile not found"));

        profile.setName(request.name());
        profile.setEmail(request.email());
        profile.setSubscriptionLevel(request.subscriptionLevel());

        studentProfileRepository.save(profile);

        return mapToStudentProfileResp(profile);
    }

    public StudentProfileResp createStudentProfile(CreateStudentProfileReq createReq) {
        //Map req to entity
        StudentProfile profile = new StudentProfile();
        profile.setName(createReq.name());
        profile.setEmail(createReq.email());

        //Save to repository
        StudentProfile savedProfile = studentProfileRepository.save(profile);

        //Map saved entity to resp
        return mapToStudentProfileResp(savedProfile);
    }

    private StudentProfileResp mapToStudentProfileResp(StudentProfile profile) {
        return new StudentProfileResp(
                profile.getId(),
                profile.getName(),
                profile.getEmail(),
                profile.getSubscriptionLevel()
        );
    }
}