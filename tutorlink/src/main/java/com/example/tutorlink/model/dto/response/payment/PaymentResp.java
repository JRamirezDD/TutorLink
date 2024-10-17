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
    private String message; // Status message
    private String transactionId; // Unique transaction ID for payment
    private String status; // Status of the payment (e.g., "Payment accepted")
}
