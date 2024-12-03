package com.tutorlink.student_domain.functional.service.feignclients;

import org.springframework.cloud.openfeign.FeignClient;

import com.tutorlink.matchmaking_domain.crossdomaininteractions.connection.controller.APIs.API_ConnectionController;

@FeignClient(value = "Client-StudentDomainManager-Connection", url = "https://localhost:20011/connections")
public interface Client_StudentDomainManager_Connection extends API_ConnectionController {

}