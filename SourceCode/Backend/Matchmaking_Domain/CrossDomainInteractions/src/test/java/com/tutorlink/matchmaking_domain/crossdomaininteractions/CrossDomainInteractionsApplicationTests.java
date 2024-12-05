package com.tutorlink.matchmaking_domain.crossdomaininteractions;

import com.tutorlink.matchmaking_domain.crossdomaininteractions.rating.controller.RatingController;
import com.tutorlink.matchmaking_domain.crossdomaininteractions.rating.model.dto.req.SubmitRatingReq;
import com.tutorlink.matchmaking_domain.crossdomaininteractions.rating.model.dto.resp.RatingResp;
import com.tutorlink.matchmaking_domain.crossdomaininteractions.rating.model.enums.StarRating;
import com.tutorlink.matchmaking_domain.crossdomaininteractions.rating.service.RatingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class RatingControllerTest {

    @Mock
    private RatingService ratingService;

    @InjectMocks
    private RatingController ratingController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSubmitRating() {
        SubmitRatingReq request = new SubmitRatingReq(123L, 456L, 5);
        RatingResp mockResponse = RatingResp.builder()
                .id(1L)
                .tutorId(456L)
                .ratingValue(StarRating.FIVE)
                .build();

        when(ratingService.submitRating(any(SubmitRatingReq.class))).thenReturn(mockResponse);

        ResponseEntity<RatingResp> responseEntity = ratingController.submitRating(request);

        assertEquals(mockResponse, responseEntity.getBody());
    }
}