package com.example.tutorlink.model.dto.response.payment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentResp {
    private Long paymentRequestId;
    private String message;
    private String transactionId;
    private String status;
}
