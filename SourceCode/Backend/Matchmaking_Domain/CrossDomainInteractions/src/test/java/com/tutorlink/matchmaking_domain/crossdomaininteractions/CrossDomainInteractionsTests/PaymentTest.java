package com.tutorlink.matchmaking_domain.crossdomaininteractions.CrossDomainInteractionsTests;

import com.tutorlink.matchmaking_domain.crossdomaininteractions.rating.repository.RatingRepository;
import com.tutorlink.matchmaking_domain.crossdomaininteractions.rating.service.RatingService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class PaymentTest {

    @Mock
    private RatingRepository ratingRepository;

    @InjectMocks
    private RatingService ratingService;

    PaymentTest() {
        MockitoAnnotations.openMocks(this); //Initialize mocks
    }

    @Test
    void testGetPayment() {
        Long tutorId = 1L;

    }
}
