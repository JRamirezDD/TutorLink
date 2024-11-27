package com.tutorlink.tutor_domain.functional.ratingviewer.service;

import com.tutorlink.tutor_domain.functional.ratingviewer.model.dto.resp.RatingResp;
import com.tutorlink.tutor_domain.functional.ratingviewer.repository.RatingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RatingViewerService {

    private final RatingRepository ratingRepository;

    public Double getAverageRating(Long tutorId) {
        return ratingRepository.calculateAverageRating(tutorId);
    }

    public List<RatingResp> getRatingsForTutor(Long tutorId) {
        return ratingRepository.findByTutorId(tutorId).stream()
                .map(rating -> RatingResp.builder()
                        .ratingId(rating.getId())
                        .tutorId(rating.getTutorId())
                        .studentId(rating.getStudentId())
                        .rating(rating.getRating())
                        .comment(rating.getComment())
                        .build())
                .collect(Collectors.toList());
    }
}

