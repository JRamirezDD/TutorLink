package com.example.tutorlink.service;

import com.example.tutorlink.model.dto.request.subscription.SubscriptionReq;
import com.example.tutorlink.model.dto.response.subscription.SubscriptionResp;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Service
public class SubscriptionService {

    private Map<Long, SubscriptionResp> subscriptionData = new HashMap<>();

    public SubscriptionResp subscribe(Long studentId, SubscriptionReq subscriptionRequestDTO) {
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = startDate.plusMonths(subscriptionRequestDTO.getDurationMonths());

        SubscriptionResp subscription = new SubscriptionResp(
                studentId,
                subscriptionRequestDTO.getSubscriptionType(),
                startDate,
                endDate,
                "Active"
        );

        subscriptionData.put(studentId, subscription);

        return subscription;
    }

    public SubscriptionResp getSubscriptionStatus(Long studentId) {
        return subscriptionData.getOrDefault(studentId, null);
    }
}

