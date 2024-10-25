package com.example.tutorlink.model.dto.response.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentStatusResp {
    private Long paymentRequestId;
    private String status;
    private Double amount;
    private Long sessionId;
    private String subject;
    private Long tutorId;
    private Long studentId;
}

