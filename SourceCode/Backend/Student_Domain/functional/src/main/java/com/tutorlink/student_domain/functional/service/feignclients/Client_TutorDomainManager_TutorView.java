package com.tutorlink.student_domain.functional.service.feignclients;

import com.tutorlink.matchmaking_domain.tutordomainmanager.tutorprofileretrieval.controller.APIs.API_TutorProfileRetrieval;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "Client-TutorDomainManager-TutorView", url = "https://localhost:30011/tutors")
public interface Client_TutorDomainManager_TutorView extends API_TutorProfileRetrieval {
}
