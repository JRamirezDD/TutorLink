package com.tutorlink.student_domain.functional.service.feignclients;

import com.tutorlink.matchmaking_domain.crossdomaininteractions.rating.controller.APIs.API_Rating;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "Client-CrossDomainInteractions-Rating", url = "https://localhost:20011/ratings")
public interface Client_CrossDomainInteractions_Rating extends API_Rating {
}
