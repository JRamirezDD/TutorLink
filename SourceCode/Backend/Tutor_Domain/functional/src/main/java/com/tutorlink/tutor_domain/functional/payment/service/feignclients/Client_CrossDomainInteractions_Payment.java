package com.tutorlink.tutor_domain.functional.payment.service.feignclients;

import com.tutorlink.matchmaking_domain.crossdomaininteractions.payment.controller.APIs.API_Payment;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "Client-CrossDomainInteractions-Payment", url = "https://localhost:20011/payments")
public interface Client_CrossDomainInteractions_Payment extends API_Payment {
}
