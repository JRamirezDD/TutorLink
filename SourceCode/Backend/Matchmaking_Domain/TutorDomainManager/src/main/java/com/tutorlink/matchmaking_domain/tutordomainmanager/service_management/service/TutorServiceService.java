package com.tutorlink.matchmaking_domain.tutordomainmanager.service_management.service;


import com.tutorlink.matchmaking_domain.tutordomainmanager.service_management.model.dto.req.AddTutorServiceReq;
import com.tutorlink.matchmaking_domain.tutordomainmanager.service_management.model.dto.resp.TutorServiceResp;
import com.tutorlink.matchmaking_domain.tutordomainmanager.service_management.model.entity.TutorService;
import com.tutorlink.matchmaking_domain.tutordomainmanager.service_management.repository.ServiceRepository;
import com.tutorlink.matchmaking_domain.tutordomainmanager.service_management.repository.TutorServiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TutorServiceService {

    private final TutorServiceRepository tutorServiceRepository;
    private final ServiceRepository serviceRepository;
    private final RatingService ratingService;

    public List<TutorServiceResp> getServicesByTutor(Long tutorId) {
        return tutorServiceRepository.findByTutorId(tutorId).stream()
                .map(service -> TutorServiceResp.builder()
                        .id(service.getId())
                        .name(service.getName())
                        .description(service.getDescription())
                        .hourlyRate(service.getHourlyRate())
                        .build())
                .collect(Collectors.toList());
    }

    public TutorServiceResp addTutorService(Long tutorId, AddTutorServiceReq request) {
        TutorService service = TutorService.builder()
                .tutorId(tutorId)
                .name(request.name())
                .description(request.description())
                .hourlyRate(request.hourlyRate())
                .build();

        TutorService savedService = tutorServiceRepository.save(service);
        return TutorServiceResp.builder()
                .id(savedService.getId())
                .name(savedService.getName())
                .description(savedService.getDescription())
                .hourlyRate(savedService.getHourlyRate())
                .build();
    }
}

