package com.example.eatgo.application;

import com.example.eatgo.domain.Review;
import com.example.eatgo.domain.ReviewRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

public class ReviewServiceTests {

    private ReviewService reviewService;

    @Mock
    private ReviewRepository reviewRepotory;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        reviewService = new ReviewService(reviewRepotory);
    }

    @Test
    public void addReview(){
        Review review = Review.builder()
                .name("sanghyun")
                .score(3)
                .description("good")
                .build();
        reviewService.addReview(review);

        verify(reviewRepotory).save(any());
    }
}