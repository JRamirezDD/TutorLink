package com.tutorlink.matchmaking_domain.tutordomainmanager.servicemanagement.service;

import com.tutorlink.matchmaking_domain.crossdomaininteractions.rating.model.dto.req.SubmitRatingReq;
import com.tutorlink.matchmaking_domain.crossdomaininteractions.rating.model.dto.resp.RatingResp;
import com.tutorlink.matchmaking_domain.tutordomainmanager.servicemanagement.model.dto.req.TutorServiceReq;
import com.tutorlink.matchmaking_domain.tutordomainmanager.servicemanagement.model.dto.resp.TutorServiceResp;
import com.tutorlink.matchmaking_domain.tutordomainmanager.servicemanagement.model.entity.TutorService;
import com.tutorlink.matchmaking_domain.tutordomainmanager.servicemanagement.repository.TutorServiceRepository;
import com.tutorlink.matchmaking_domain.tutordomainmanager.servicemanagement.service.feignclients.Client_CrossDomainInteractions_Rating;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TutorServiceService {

    private final TutorServiceRepository tutorServiceRepository;
    private final Client_CrossDomainInteractions_Rating ratingClient; // Feign Client Injection

    public TutorServiceResp createService(TutorServiceReq request) {
        TutorService tutorService = TutorService.builder()
                .tutorId(request.tutorId())
                .serviceName(request.serviceName())
                .hourlyRate(request.hourlyRate())
                .description(request.description())
                .build();

        tutorService = tutorServiceRepository.save(tutorService);

        Double averageRating = ratingClient.getAverageRatingForTutor(tutorService.getTutorId()).getBody();

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

        Double averageRating = ratingClient.getAverageRatingForTutor(tutorService.getTutorId()).getBody();

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
                    Double averageRating = ratingClient.getAverageRatingForTutor(service.getTutorId()).getBody();
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

    public RatingResp submitRating(SubmitRatingReq request) {
        return ratingClient.submitRating(request).getBody();
    }

    public List<RatingResp> getRatingsForTutor(Long tutorId) {
        return ratingClient.getRatingsForTutor(tutorId).getBody();
    }
}

