package com.example.tutorlink.controller;


import com.example.tutorlink.model.dto.request.rating.RatingDTO;
import com.example.tutorlink.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping
    public ResponseEntity<String> submitRating(@RequestBody RatingDTO ratingDTO) {
        ratingService.submitRating(ratingDTO);

        return ResponseEntity.ok("rating submitted");
    }

    @GetMapping("/{tutorId}")
    public ResponseEntity<List<RatingDTO>> getRatingsByTutor(@PathVariable Long tutorId) {
        List<RatingDTO> tutorRatings = ratingService.getRatingsByTutor(tutorId);

        return ResponseEntity.ok(tutorRatings);
    }
}


