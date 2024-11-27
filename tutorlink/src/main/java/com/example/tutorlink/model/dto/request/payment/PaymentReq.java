package com.example.tutorlink.model.dto.request.payment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentReq {
    private Long sessionId;
    private Long studentId;
    private Long tutorId;
    private Double amount;
    private String subject;
    private Double hourlyRate;
    private Integer duration; // in hours
}

