package com.tutorlink.student_domain.functional.model.dto.request;

import lombok.Builder;

@Builder
public record UpdateStudentProfileReq(
        String name,
        String email,
        String subscriptionLevel
) {
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getSubscriptionLevel() {
        return subscriptionLevel;
    }
}

