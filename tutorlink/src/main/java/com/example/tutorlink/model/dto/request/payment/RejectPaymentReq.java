package com.example.tutorlink.model.dto.request.payment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RejectPaymentReq {
    private Long studentId;
    private Long tutorId;
    private Long paymentRequestId;
}


