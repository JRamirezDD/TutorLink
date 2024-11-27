package com.tutorlink.matchmaking_domain.tutordomainmanager.tutorprofileretrieval.proxy;

import com.tutorlink.matchmaking_domain.tutordomainmanager.tutorprofileretrieval.model.dto.resp.TutorProfileResp;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TutorDomainProxy {

    public TutorProfileResp fetchTutorProfile(Long tutorId) {
        //simulated for now
        return new TutorProfileResp(tutorId, "Bob Masterson", "Computer Science", "Berlin", 4.5);
    }

    public List<TutorProfileResp> fetchAllTutorProfiles() {
        //simulated
        return List.of(
                new TutorProfileResp(1L, "Bob Masterson", "Computer Science", "Berlin", 4.5),
                new TutorProfileResp(2L, "Jorge Ramirez", "Mathematics", "Leipzig", 4.8)
        );
    }
}

