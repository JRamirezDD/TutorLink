package com.tutorlink.matchmaking_domain.tutordomainmanager.servicemanagement.service;

import com.tutorlink.matchmaking_domain.tutordomainmanager.servicemanagement.model.dto.req.TutorServiceReq;
import com.tutorlink.matchmaking_domain.tutordomainmanager.servicemanagement.model.dto.resp.TutorServiceResp;
import com.tutorlink.matchmaking_domain.tutordomainmanager.servicemanagement.model.entity.TutorService;
import com.tutorlink.matchmaking_domain.tutordomainmanager.servicemanagement.repository.TutorServiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TutorServiceService {

    private final TutorServiceRepository tutorServiceRepository;
    private final RatingService ratingService;

    public TutorServiceResp createService(TutorServiceReq request) {
        TutorService tutorService = TutorService.builder()
                .tutorId(request.tutorId())
                .serviceName(request.serviceName())
                .hourlyRate(request.hourlyRate())
                .description(request.description())
                .build();

        tutorService = tutorServiceRepository.save(tutorService);

        return new TutorServiceResp(
                tutorService.getId(),
                tutorService.getTutorId(),
                tutorService.getServiceName(),
                tutorService.getHourlyRate(),
                tutorService.getDescription(),
                ratingService.getAverageRatingForTutor(tutorService.getTutorId())
        );
    }

    public TutorServiceResp getServiceById(Long serviceId) {
        TutorService tutorService = tutorServiceRepository.findById(serviceId)
                .orElseThrow(() -> new RuntimeException("Service not found"));

        return new TutorServiceResp(
                tutorService.getId(),
                tutorService.getTutorId(),
                tutorService.getServiceName(),
                tutorService.getHourlyRate(),
                tutorService.getDescription(),
                ratingService.getAverageRatingForTutor(tutorService.getTutorId())
        );
    }

    public List<TutorServiceResp> getAllServices() {
        return tutorServiceRepository.findAll().stream()
                .map(service -> new TutorServiceResp(
                        service.getId(),
                        service.getTutorId(),
                        service.getServiceName(),
                        service.getHourlyRate(),
                        service.getDescription(),
                        ratingService.getAverageRatingForTutor(service.getTutorId())
                ))
                .collect(Collectors.toList());
    }

    public void deleteService(Long serviceId) {
        tutorServiceRepository.deleteById(serviceId);
    }
}

