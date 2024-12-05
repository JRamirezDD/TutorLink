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

    public TutorServiceResp createService(TutorServiceReq request) {
        TutorService tutorService = TutorService.builder()
                .tutorId(request.tutorId())
                .serviceName(request.serviceName())
                .hourlyRate(request.hourlyRate())
                .description(request.description())
                .build();

        tutorService = tutorServiceRepository.save(tutorService);

        // Assuming we compute the average rating in this service or it is stored in the database
        Double averageRating = computeAverageRating(tutorService.getTutorId());

        return new TutorServiceResp(
                tutorService.getId(),
                tutorService.getTutorId(),
                tutorService.getServiceName(),
                tutorService.getHourlyRate(),
                tutorService.getDescription(),
                averageRating
        );
    }

    public TutorServiceResp getServiceById(Long serviceId) {
        TutorService tutorService = tutorServiceRepository.findById(serviceId)
                .orElseThrow(() -> new RuntimeException("Service not found"));

        Double averageRating = computeAverageRating(tutorService.getTutorId());

        return new TutorServiceResp(
                tutorService.getId(),
                tutorService.getTutorId(),
                tutorService.getServiceName(),
                tutorService.getHourlyRate(),
                tutorService.getDescription(),
                averageRating
        );
    }

    public List<TutorServiceResp> getAllServices() {
        return tutorServiceRepository.findAll().stream()
                .map(service -> {
                    Double averageRating = computeAverageRating(service.getTutorId());
                    return new TutorServiceResp(
                            service.getId(),
                            service.getTutorId(),
                            service.getServiceName(),
                            service.getHourlyRate(),
                            service.getDescription(),
                            averageRating
                    );
                })
                .collect(Collectors.toList());
    }

    public void deleteService(Long serviceId) {
        tutorServiceRepository.deleteById(serviceId);
    }

    // Mock method to compute the average rating (replace with actual implementation)
    private Double computeAverageRating(Long tutorId) {
        // Logic to compute average rating locally or fetch from the repository
        return tutorServiceRepository.findAverageRatingForTutor(tutorId);
    }
}


