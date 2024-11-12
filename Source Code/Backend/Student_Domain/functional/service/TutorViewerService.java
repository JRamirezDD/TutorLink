package com.tutorlink.student_domain.functional.service;


import com.tutorlink.student_domain.functional.model.dto.response.TutorProfileResp;
import com.tutorlink.student_domain.functional.repository.TutorViewerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TutorViewerService {

    private final TutorViewerRepository tutorViewerRepository;
    private final SubscriptionService subscriptionService; //gets sub level

    public List<TutorProfileResp> getAllTutors() {
        return tutorViewerRepository.findAllTutors();
    }

    public TutorProfileResp getTutorProfileById(Long studentId, Long tutorId) {
        String subscriptionLevel = subscriptionService.getSubscriptionLevel(studentId);
        if ("Silver".equals(subscriptionLevel)) {
            long dailyViews = tutorViewerRepository.countDailyViews(studentId, LocalDate.now());
            if (dailyViews >= 3) {
                throw new RuntimeException("Daily view limit for Silver students reached.");
            }
            tutorViewerRepository.incrementDailyViewCount(studentId, tutorId, LocalDate.now());
        }
        return tutorViewerRepository.findTutorProfileById(tutorId);
    }
}

