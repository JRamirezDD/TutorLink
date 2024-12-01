package com.tutorlink.tutor_domain.functional.messaging.service.feignclient;


import com.tutorlink.matchmaking_domain.crossdomaininteractions.messaging.controller.APIs.API_Messaging;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "Client_CrossDomainInteractions_Messages", url = "https://localhost:20011/messages")
public interface Client_CrossDomainInteractions_Messages extends API_Messaging {
}
