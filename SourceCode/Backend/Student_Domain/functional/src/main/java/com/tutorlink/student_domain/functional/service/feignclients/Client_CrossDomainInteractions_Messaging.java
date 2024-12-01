package com.tutorlink.student_domain.functional.service.feignclients;


import com.tutorlink.matchmaking_domain.crossdomaininteractions.messaging.controller.APIs.API_Messaging;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "CrossDomainInteractions", url = "https://localhost:20011/messages")
public interface Client_CrossDomainInteractions_Messaging extends API_Messaging {
}
