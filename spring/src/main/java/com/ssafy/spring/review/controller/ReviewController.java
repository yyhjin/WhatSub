package com.ssafy.spring.review.controller;

import com.ssafy.spring.comb.repository.CombPostRepository;
import com.ssafy.spring.SuccessResponseResult;
import com.ssafy.spring.review.dto.ReviewRequest;
import com.ssafy.spring.review.dto.ReviewResponse;
import com.ssafy.spring.review.entity.Review;
import com.ssafy.spring.review.repository.ReviewRepository;
import com.ssafy.spring.review.service.ReviewServiceImpl;
import com.ssafy.spring.user.repository.UserRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Api(value = "review-controller", tags={"review-controller"})
@RestController
public class ReviewController {
    private final ReviewServiceImpl reviewService;
    private final ReviewRepository reviewRepository;
    private final CombPostRepository combPostRepository;
    private final UserRepository userRepository;
    @Autowired
    public ReviewController(ReviewServiceImpl reviewService, ReviewRepository reviewRepository, CombPostRepository combPostRepository, UserRepository userRepository){
        this.reviewService = reviewService;
        this.reviewRepository = reviewRepository;
        this.combPostRepository = combPostRepository;
        this.userRepository = userRepository;
    }

    @ApiOperation(value = "리뷰 생성", notes="리뷰를 생성한다", httpMethod = "POST")
    @PostMapping("/review")
    public SuccessResponseResult create(@RequestBody ReviewRequest.CreateRequest request) {
        Review review = Review.builder()
                .content(request.getContent())
                .score(request.getScore())
                .combinationPost(combPostRepository.findByCombinationPostId(request.getCombinationPostId()))
                .user(userRepository.getUserByUserId(request.getUserId()))
                .build();

        reviewService.create(review);
        return new SuccessResponseResult();
    }
    @ApiOperation(value = "리뷰 수정", notes="리뷰를 수정한다", httpMethod = "PUT")
    @PutMapping("/review/{reviewId}")
    public SuccessResponseResult update(@RequestBody ReviewRequest.CreateRequest request, @PathVariable int reviewId) {
        Review review = Review.builder()
                .content(request.getContent())
                .score(request.getScore())
                .build();

        reviewService.update(review, reviewId);
        return new SuccessResponseResult();
    }
    @ApiOperation(value = "리뷰 삭제", notes="리뷰를 삭제한다", httpMethod = "DELETE")
    @DeleteMapping("/review/{reviewId}")
    public SuccessResponseResult delete(@PathVariable int reviewId){
        reviewService.delete(reviewId);
        return new SuccessResponseResult();
    }

    @ApiOperation(value = "리뷰 조회", notes="게시글id를 받아 리뷰 목록을 반환한다", httpMethod = "GET")
    @GetMapping("/review/{combinationPostId}")
    public SuccessResponseResult getReviews(@PathVariable int combinationPostId) {
        List<Review> reviews = reviewService.getReviewList(combinationPostId);
        List<ReviewResponse.ResponseDto> reviewList = reviews.stream()
                .map(Review::EntityToDto)
                .collect(Collectors.toList());

        return new SuccessResponseResult(reviewList);
    }




}
