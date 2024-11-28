package com.tutorlink.student_domain.functional.service.feignclients;

import com.tutorlink.matchmaking_domain.crossdomaininteractions.connection.controller.APIs.API_ConnectionController;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "StudentDomainManager", url = "https://localhost:20011/connections")
public interface Client_StudentDomainManager extends API_ConnectionController  {

}


