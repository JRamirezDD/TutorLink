package com.tutorlink.matchmaking_domain.crossdomaininteractions.rating.service;

import com.tutorlink.matchmaking_domain.crossdomaininteractions.rating.model.dto.req.SubmitRatingReq;
import com.tutorlink.matchmaking_domain.crossdomaininteractions.rating.model.dto.resp.RatingResp;
import com.tutorlink.matchmaking_domain.crossdomaininteractions.rating.model.entity.Rating;
import com.tutorlink.matchmaking_domain.crossdomaininteractions.rating.repository.RatingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RatingService {

    private final RatingRepository ratingRepository;

    public Double getAverageRatingForTutor(Long tutorId) {
        return ratingRepository.findAverageByTutorId(tutorId); // Average works seamlessly for integers
    }

    public RatingResp submitRating(SubmitRatingReq request) {
        Rating rating = Rating.builder()
                .studentId(request.getStudentId())
                .tutorId(request.getTutorId())
                .ratingValue(request.getRatingValue()) // Directly use the integer value
                .build();

        rating = ratingRepository.save(rating);

        return new RatingResp(
                rating.getId(),
                rating.getTutorId(),
                rating.getStudentId(),
                rating.getRatingValue()
        );
    }

    public List<RatingResp> getRatingsForTutor(Long tutorId) {
        return ratingRepository.findByTutorId(tutorId).stream()
                .map(rating -> new RatingResp(
                        rating.getId(),
                        rating.getTutorId(),
                        rating.getStudentId(),
                        rating.getRatingValue()
                ))
                .collect(Collectors.toList());
    }
}



