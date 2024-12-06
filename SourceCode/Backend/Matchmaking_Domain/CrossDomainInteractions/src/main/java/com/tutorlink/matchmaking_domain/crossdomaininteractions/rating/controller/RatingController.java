package com.tutorlink.matchmaking_domain.crossdomaininteractions.rating.controller;

import com.tutorlink.matchmaking_domain.crossdomaininteractions.rating.model.dto.req.SubmitRatingReq;
import com.tutorlink.matchmaking_domain.crossdomaininteractions.rating.model.dto.resp.RatingResp;
import com.tutorlink.matchmaking_domain.crossdomaininteractions.rating.service.RatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ratings")
@RequiredArgsConstructor
public class RatingController {

    private final RatingService ratingService;

    @PostMapping
    public ResponseEntity<RatingResp> submitRating(@RequestBody SubmitRatingReq request) {
        RatingResp response = ratingService.submitRating(request);
        return ResponseEntity.ok(response);
    }

    public ResponseEntity<Double> getAverageRatingForTutor(@PathVariable Long tutorId) {
        Double averageRating = ratingService.getAverageRatingForTutor(tutorId);
        return ResponseEntity.ok(averageRating);
    }


}
