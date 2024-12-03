package com.tutorlink.student_domain.functional.service.feignclients;

import com.tutorlink.matchmaking_domain.studentdomainmanager.controller.APIs.API_StudentProfileRetrieval;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "student-profile-management", url = "https://localhost:20011")
public interface Client_CrossDomainInteractions_StudentProfileRetrieval extends API_StudentProfileRetrieval {
}