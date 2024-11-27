package com.tutorlink.tutor_domain.functional.ratingviewer.controller;

import com.tutorlink.tutor_domain.functional.ratingviewer.model.dto.resp.RatingResp;
import com.tutorlink.tutor_domain.functional.ratingviewer.service.RatingViewerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
@RequiredArgsConstructor
public class RatingViewerController {

    private final RatingViewerService ratingViewerService;

    //get average rating for a tutor
    @GetMapping("/{tutorId}/average")
    public ResponseEntity<Double> getAverageRating(@PathVariable Long tutorId) {
        Double averageRating = ratingViewerService.getAverageRating(tutorId);
        return ResponseEntity.ok(averageRating);
    }

    //get all individual ratings for a tutor
    @GetMapping("/{tutorId}")
    public ResponseEntity<List<RatingResp>> getRatingsForTutor(@PathVariable Long tutorId) {
        List<RatingResp> ratings = ratingViewerService.getRatingsForTutor(tutorId);
        return ResponseEntity.ok(ratings);
    }
}

