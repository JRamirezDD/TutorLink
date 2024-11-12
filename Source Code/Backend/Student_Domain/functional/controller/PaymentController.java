package com.tutorlink.student_domain.functional.controller;


import com.tutorlink.student_domain.functional.model.dto.request.PaymentReq;
import com.tutorlink.student_domain.functional.model.dto.response.PaymentResp;
import com.tutorlink.student_domain.functional.service.PaymentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    //create a payment request (end of tutoring session)
    @Operation(summary = "Create a payment request", description = "Generates a payment request at the end of a tutoring session.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Payment request created successfully",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PaymentResp.class),
                            examples = @ExampleObject(value = "{\"paymentId\": 1001, \"amount\": 50.0, \"status\": \"PENDING\", \"requestDate\": \"2024-11-12T10:15:30\"}")
                    )),
            @ApiResponse(responseCode = "400", description = "Invalid payment request data")
    })
    @PostMapping("/request")
    public ResponseEntity<PaymentResp> createPaymentRequest(@RequestBody PaymentReq req) {
        PaymentResp paymentResponse = paymentService.createPaymentRequest(req);
        return ResponseEntity.ok(paymentResponse);
    }

    //pay a payment request
    @Operation(summary = "Pay a payment request", description = "Marks a payment request as paid.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Payment successful",
                    content = @Content(mediaType = "application/json",
                            examples = @ExampleObject(value = "\"Payment successful\"")
                    )),
            @ApiResponse(responseCode = "404", description = "Payment request not found"),
            @ApiResponse(responseCode = "400", description = "Invalid payment ID")
    })
    @PostMapping("/{paymentId}/pay")
    public ResponseEntity<String> payRequest(@PathVariable Long paymentId) {
        paymentService.payRequest(paymentId);
        return ResponseEntity.ok("Payment successful");
    }

    //decline a payment request
    @Operation(summary = "Decline a payment request", description = "Marks a payment request as declined.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Payment declined",
                    content = @Content(mediaType = "application/json",
                            examples = @ExampleObject(value = "\"Payment declined\"")
                    )),
            @ApiResponse(responseCode = "404", description = "Payment request not found"),
            @ApiResponse(responseCode = "400", description = "Invalid payment ID")
    })
    @PostMapping("/{paymentId}/decline")
    public ResponseEntity<String> declineRequest(@PathVariable Long paymentId) {
        paymentService.declineRequest(paymentId);
        return ResponseEntity.ok("Payment declined");
    }
}


