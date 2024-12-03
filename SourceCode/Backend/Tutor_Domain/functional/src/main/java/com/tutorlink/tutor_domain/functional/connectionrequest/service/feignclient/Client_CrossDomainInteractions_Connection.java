package com.tutorlink.tutor_domain.functional.connectionrequest.service.feignclient;


import com.tutorlink.matchmaking_domain.crossdomaininteractions.connection.controller.APIs.API_ConnectionController;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "Client-CrossDomainInteractions-Connection", url = "https://localhost:20011/connections")
public interface Client_CrossDomainInteractions_Connection extends API_ConnectionController {
}
