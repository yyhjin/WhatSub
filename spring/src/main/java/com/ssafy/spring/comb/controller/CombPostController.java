package com.ssafy.spring.comb.controller;

import com.ssafy.spring.SuccessResponseResult;
import com.ssafy.spring.comb.dto.CombDto;
import com.ssafy.spring.comb.dto.CombPostRequest;
import com.ssafy.spring.comb.dto.CombPostResponse;
import com.ssafy.spring.comb.entity.Combination;
import com.ssafy.spring.comb.entity.CombinationPost;
import com.ssafy.spring.comb.entity.Menu;
import com.ssafy.spring.comb.service.CombPostService;
import com.ssafy.spring.comb.service.CombService;
import com.ssafy.spring.comb.service.MenuService;
import com.ssafy.spring.comb.service.S3Service;
import com.ssafy.spring.review.dto.ReviewResponse;
import com.ssafy.spring.review.entity.Review;
import com.ssafy.spring.review.service.ReviewService;
import com.ssafy.spring.user.entity.User;
import com.ssafy.spring.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Api(value = "꿀조합 게시판", tags={"combination post-controller"})
@RestController
@RequestMapping("/comb")
public class CombPostController {

    private final CombService combService;
    private final CombPostService combPostService;
    private final UserService userService;
    private final MenuService menuService;
    private final S3Service s3Service;
    private final ReviewService reviewService;

    public CombPostController(CombService combService, CombPostService combPostService, UserService userService, MenuService menuService, S3Service s3Service, ReviewService reviewService) {
        this.combService = combService;
        this.combPostService = combPostService;
        this.userService = userService;
        this.menuService = menuService;
        this.s3Service = s3Service;
        this.reviewService = reviewService;
    }


    @ApiOperation(value = "조합 생성", notes = "주문 시 기존에 없는 조합일 경우 해당 조합을 저장한다.", httpMethod = "POST")
    @PostMapping
    @Transactional
    public SuccessResponseResult createComb(@RequestBody CombDto combination) {

        Combination newcomb = combService.save(combination);

        return new SuccessResponseResult();
    }


    @ApiOperation(value = "게시판 등록 여부", notes = "해당 조합이 꿀조합 게시판에 있는지 확인한다.\n있으면 해당 게시글 번호 반환 / 없으면 -1 반환", httpMethod = "GET")
    @GetMapping("/exist/{combinationId}")
    public SuccessResponseResult checkPostExist(@PathVariable String combinationId) {

        CombinationPost post = combPostService.findByCombination_CombinationId(combinationId);
        int postId;

        if(post == null)
            postId = -1;
        else
            postId = post.getCombinationPostId();

        return new SuccessResponseResult(postId);
    }


    @ApiOperation(value = "꿀조합 게시글 등록", notes = "꿀조합 게시판에 글을 등록한다.", httpMethod = "POST")
    @PostMapping("/board")
    @Transactional
    public SuccessResponseResult createCombPost(@RequestPart(value = "combPostRequest") CombPostRequest combPostRequest, @RequestPart(value = "file", required = false) MultipartFile file) {

        Combination comb = combService.findByCombinationId(combPostRequest.getCombinationId());
        User user = userService.getUserByUserId(combPostRequest.getUserId());

        String imgurl;
        if(file.isEmpty()) {
            String menuid = combPostRequest.getCombinationId().substring(0,1);
            Menu menu = menuService.getMenuByMenuId(menuid);
            imgurl = menu.getImgUrl();
        }
        else
            imgurl = s3Service.uploadOneFile(file);

        CombinationPost newPost = combPostService.save(comb, user, imgurl, combPostRequest);
        
        return new SuccessResponseResult();
    }


    @ApiOperation(value = "게시글 조회", notes = "해당 게시글의 정보들을 조회한다.", httpMethod = "GET")
    @GetMapping("/{combinationPostId}")
    public SuccessResponseResult getPostDetail(@PathVariable int combinationPostId) {

        CombPostResponse.PostDetailResponse response = new CombPostResponse.PostDetailResponse();

        CombinationPost post = combPostService.findByCombinationPostId(combinationPostId);

        response.setCombinationPostId(combinationPostId);
        response.setCombination(post.getCombination());
        response.setCombName(post.getCombName());
        response.setContent(post.getContent());
        response.setCreatedAt(post.getCreatedAt());
        response.setLikesCnt(post.getLikesCnt());
        response.setStatistics(post.getStatistics());
        response.setImgUrl(post.getImgUrl());
        response.setScoreAvg(post.getScoreAvg());

        List<Review> reviews = reviewService.getReviewList(combinationPostId);
        List<ReviewResponse.ResponseDto> reviewList = reviews.stream()
                .map(Review::EntityToDto)
                .collect(Collectors.toList());

        response.setReviews(reviewList);

        return new SuccessResponseResult(response);
    }

    @ApiOperation(value = "메뉴로 조회", notes = "해당하는 메뉴의 게시글 목록을 조회한다.", httpMethod = "GET")
    @GetMapping("/menu/{menuId}")
    public SuccessResponseResult getPostByMenu(@PathVariable String menuId) {

        List<CombPostResponse.PostResponse> posts = new ArrayList<>();

        List<CombinationPost> list = combPostService.findAllByMenuId(menuId);

        for(int i = 0; i < list.size(); i++) {
            CombinationPost current = list.get(i);
            CombPostResponse.PostResponse response = new CombPostResponse.PostResponse();

            response.setCombination(current.getCombination());
            response.setCombName(current.getCombName());
            response.setCombinationPostId(current.getCombinationPostId());
            response.setCreatedAt(current.getCreatedAt());
            response.setImgUrl(current.getImgUrl());
            response.setLikesCnt(current.getLikesCnt());
            response.setScoreAvg(current.getScoreAvg());

            posts.add(response);
        }

        return new SuccessResponseResult(posts);
    }

    @ApiOperation(value = "Best 게시글 조회", notes = "Best 게시글의 정보들을 조회한다.", httpMethod = "GET")
    @GetMapping("/best")
    public SuccessResponseResult getBestPost() {

        CombPostResponse.PostResponse response = new CombPostResponse.PostResponse();

        CombinationPost post = combPostService.findTopByOrderByLikesCntDescScoreAvgDesc();

        response.setCombination(post.getCombination());
        response.setCombName(post.getCombName());
        response.setCombinationPostId(post.getCombinationPostId());
        response.setCreatedAt(post.getCreatedAt());
        response.setImgUrl(post.getImgUrl());
        response.setLikesCnt(post.getLikesCnt());
        response.setScoreAvg(post.getScoreAvg());

        return new SuccessResponseResult(response);
    }

}


