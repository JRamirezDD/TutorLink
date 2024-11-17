package com.tutorlink.student_domain.functional.service;


import com.tutorlink.student_domain.functional.model.dto.response.SubscriptionResp;
import com.tutorlink.student_domain.functional.model.entity.Subscription;
import com.tutorlink.student_domain.functional.repository.SubscriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
@RequiredArgsConstructor
public class SubscriptionService {
        
    private final SubscriptionRepository subscriptionRepository = null;

    //sub upgrade to GOLD!!
    public SubscriptionResp upgradeToGold(Long studentId) {
        Subscription subscription = subscriptionRepository.findByStudentId(studentId)
                .orElse(new Subscription(studentId, "Silver", LocalDateTime.now(), null));

        subscription.setPlan("Gold");
        subscription.setExpiryDate(LocalDateTime.now().plusMonths(1)); // Example duration for "Gold"
        subscriptionRepository.save(subscription);

        return new SubscriptionResp(
                subscription.getStudentId(),
                subscription.getPlan(),
                subscription.getStartDate(),
                subscription.getExpiryDate()
        );
    }

    // retrieve sub status, including sub level (gold/silver)
    public SubscriptionResp getSubscription(Long studentId) {
        Subscription subscription = subscriptionRepository.findByStudentId(studentId)
                .orElse(new Subscription(studentId, "Silver", LocalDateTime.now(), null));

        return new SubscriptionResp(
                subscription.getStudentId(),
                subscription.getPlan(),
                subscription.getStartDate(),
                subscription.getExpiryDate()
        );
    }

    //retrieve sub lvl of the student
    public String getSubscriptionLevel(Long studentId) {
        return subscriptionRepository.findByStudentId(studentId)
                .map(Subscription::getPlan)
                .orElse("Silver");
    }
}


