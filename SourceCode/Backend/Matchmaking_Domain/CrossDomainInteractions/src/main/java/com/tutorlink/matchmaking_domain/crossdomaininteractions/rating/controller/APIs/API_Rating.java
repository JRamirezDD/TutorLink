package com.tutorlink.matchmaking_domain.crossdomaininteractions.rating.controller.APIs;

import com.tutorlink.matchmaking_domain.crossdomaininteractions.rating.model.dto.req.SubmitRatingReq;
import com.tutorlink.matchmaking_domain.crossdomaininteractions.rating.model.dto.resp.RatingResp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface API_Rating {

    @PostMapping
    ResponseEntity<RatingResp> submitRating(@RequestBody SubmitRatingReq request);

    @GetMapping("/{tutorId}/average")
    ResponseEntity<Double> getAverageRatingForTutor(@PathVariable("tutorId") Long tutorId);

    @GetMapping("/{tutorId}/ratings")
    ResponseEntity<List<RatingResp>> getRatingsForTutor(@PathVariable("tutorId") Long tutorId);
}



