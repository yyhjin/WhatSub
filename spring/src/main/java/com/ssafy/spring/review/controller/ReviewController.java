package com.ssafy.spring.review.controller;

import com.ssafy.spring.comb.repository.CombPostRepository;
import com.ssafy.spring.SuccessResponseResult;
import com.ssafy.spring.comb.service.CombPostService;
import com.ssafy.spring.review.dto.ReviewRequest;
import com.ssafy.spring.review.dto.ReviewResponse;
import com.ssafy.spring.review.entity.Review;
import com.ssafy.spring.review.repository.ReviewRepository;
import com.ssafy.spring.review.service.ReviewService;
import com.ssafy.spring.user.repository.UserRepository;
import com.ssafy.spring.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Api(value = "review-controller", tags={"review-controller"})
@RestController
public class ReviewController {
    private final ReviewService reviewService;
    private final CombPostService combPostService;
    private final UserService userService;
    @Autowired
    public ReviewController(ReviewService reviewService, CombPostService combPostService, UserService userService){
        this.reviewService = reviewService;
        this.combPostService = combPostService;
        this.userService = userService;
    }

    @ApiOperation(value = "리뷰 생성", notes="리뷰를 생성한다", httpMethod = "POST")
    @PostMapping("/review")
    public SuccessResponseResult create(@RequestBody ReviewRequest.CreateRequest request) {
        Review review = Review.builder()
                .content(request.getContent())
                .score(request.getScore())
                .combinationPost(combPostService.findByCombinationPostId(request.getCombinationPostId()))
                .user(userService.getUserByUserId(request.getUserId()))
                .build();

        reviewService.create(review);

        // 게시글 평점 업데이트
        List<Review> reviews = reviewService.getReviewList(request.getCombinationPostId());
        float avg = 0;
        for (int i = 0; i < reviews.size(); i++) {
            avg += reviews.get(i).getScore();
        }
        avg /= reviews.size();
        avg = Math.round(avg*10)/10.0f;
        combPostService.scoreUpdate(request.getCombinationPostId(), avg);

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

        // 게시글 평점 업데이트
        List<Review> reviews = reviewService.getReviewList(request.getCombinationPostId());
        float avg = 0;
        for (int i = 0; i < reviews.size(); i++) {
            avg += reviews.get(i).getScore();
        }
        avg /= reviews.size();
        avg = Math.round(avg*10)/10.0f;
        combPostService.scoreUpdate(request.getCombinationPostId(), avg);

        return new SuccessResponseResult();
    }
    @ApiOperation(value = "리뷰 삭제", notes="리뷰를 삭제한다", httpMethod = "DELETE")
    @DeleteMapping("/review/{reviewId}")
    public SuccessResponseResult delete(@PathVariable int reviewId, @RequestParam int postId){
        reviewService.delete(reviewId);

        // 게시글 평점 업데이트
        List<Review> reviews = reviewService.getReviewList(postId);
        float avg = 0;
        for (int i = 0; i < reviews.size(); i++) {
            avg += reviews.get(i).getScore();
        }
        avg /= reviews.size();
        avg = Math.round(avg*10)/10.0f;
        combPostService.scoreUpdate(postId, avg);

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
