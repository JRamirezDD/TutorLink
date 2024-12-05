package com.tutorlink.matchmaking_domain.crossdomaininteractions.CrossDomainInteractionsTests;

import com.tutorlink.matchmaking_domain.crossdomaininteractions.rating.repository.RatingRepository;
import com.tutorlink.matchmaking_domain.crossdomaininteractions.rating.service.RatingService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class RatingServiceTest {

    @Mock
    private RatingRepository ratingRepository;

    @InjectMocks
    private RatingService ratingService;

    RatingServiceTest() {
        MockitoAnnotations.openMocks(this); //Initialize mocks
    }

    @Test
    void testGetAverageRatingForTutor() {
        Long tutorId = 1L;
        when(ratingRepository.findAverageByTutorId(tutorId)).thenReturn(4.5);

        Double averageRating = ratingService.getAverageRatingForTutor(tutorId);

        assertEquals(4.5, averageRating);
        verify(ratingRepository, times(1)).findAverageByTutorId(tutorId);
    }
}
