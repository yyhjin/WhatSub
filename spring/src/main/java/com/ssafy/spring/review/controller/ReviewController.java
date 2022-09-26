package com.ssafy.spring.review.controller;

import com.ssafy.spring.comb.entity.CombinationPost;
import com.ssafy.spring.review.entity.dto.ReviewResponse;
import com.ssafy.spring.review.entity.entity.Review;
import com.ssafy.spring.review.entity.repository.ReviewJpaRepository;
import com.ssafy.spring.review.entity.repository.ReviewRepository;
import com.ssafy.spring.review.entity.service.ReviewService;
import com.ssafy.spring.review.entity.service.ReviewServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "review-controller", tags={"review-controller"})
@RestController
public class ReviewController {

    private final ReviewServiceImpl reviewService;
    private final ReviewJpaRepository reviewJpaRepository;
    @Autowired
    public ReviewController(ReviewServiceImpl reviewService, ReviewJpaRepository reviewJpaRepository){
        this.reviewService = reviewService;
        this.reviewJpaRepository = reviewJpaRepository;
    }

//    @ApiOperation(value = "리뷰 목록 반환", notes="리뷰 목록을 반환한다",httpMethod = "GET")
//    @GetMapping("/review")
//    public ReviewResponse read() {
//        ReviewResponse reviewResponse = ReviewResponse.builder()
//                .combinationId("1,abc,2,de")
//                .content("맛있음")
//                .score(4)
//                .userId(1)
//                .build();
//        return reviewResponse;
//    }
    @ApiOperation(value = "리뷰 생성", notes="리뷰를 생성한다", httpMethod = "POST")
    @PostMapping("/review")
    public String create(Review review) {
        reviewService.create(review);
        return "댓글이 생성되었습니다.";
    }
    @ApiOperation(value = "리뷰 수정", notes="리뷰를 수정한다", httpMethod = "PUT")
    @PutMapping("/review/{id}")
    public String update(Review review, @PathVariable int id) {
        reviewService.update(review, id);
        return "댓글이 수정되었습니다.";
    }
    @ApiOperation(value = "리뷰 삭제", notes="리뷰를 삭제한다", httpMethod = "DELETE")
    @DeleteMapping("/review/{id}")
    public String delete(@PathVariable int id){
        reviewService.delete(id);
        return "댓글이 삭제되었습니다.";
    }
    @ApiOperation(value = "리뷰 조회", notes="게시글id를 받아 리뷰 목록을 반환한다", httpMethod = "GET")
    @GetMapping("/review/{combinationPostId}")
    public String getReviews(@PathVariable int combinationPostId) { // List<Review>반환해야함 일단 String으로 테스트
        reviewService.getReviewList(combinationPostId);
        System.out.println(combinationPostId);
        return "1";
    }

}
