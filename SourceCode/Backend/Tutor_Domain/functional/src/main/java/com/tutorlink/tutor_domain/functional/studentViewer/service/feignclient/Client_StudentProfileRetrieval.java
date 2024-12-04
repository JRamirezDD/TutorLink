package com.tutorlink.tutor_domain.functional.studentViewer.service.feignclient;

import com.tutorlink.matchmaking_domain.studentdomainmanager.controller.APIs.API_StudentProfileRetrieval;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "StudentProfileRetrieval", url = "https://localhost20012")
public interface Client_StudentProfileRetrieval extends API_StudentProfileRetrieval {
}
