package com.ssafy.spring.comb.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssafy.spring.SuccessResponseResult;
import com.ssafy.spring.comb.dto.CombDto;
import com.ssafy.spring.comb.dto.CombPostRequest;
import com.ssafy.spring.comb.dto.CombPostResponse;
import com.ssafy.spring.comb.dto.StatisticsDto;
import com.ssafy.spring.comb.entity.Combination;
import com.ssafy.spring.comb.entity.CombinationPost;
import com.ssafy.spring.comb.entity.Menu;
import com.ssafy.spring.comb.service.*;
import com.ssafy.spring.order.entity.OrderHistory;
import com.ssafy.spring.order.service.OrderHistoryService;
import com.ssafy.spring.review.dto.ReviewResponse;
import com.ssafy.spring.review.entity.Review;
import com.ssafy.spring.review.service.ReviewService;
import com.ssafy.spring.user.entity.Dib;
import com.ssafy.spring.user.entity.User;
import com.ssafy.spring.user.service.DibService;
import com.ssafy.spring.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Api(value = "꿀조합 게시판", tags={"combination post-controller"})
@RestController
@RequestMapping("/comb")
@EnableAsync
public class CombPostController {

    private final CombService combService;
    private final CombPostService combPostService;
    private final UserService userService;
    private final MenuService menuService;
    private final S3Service s3Service;
    private final ReviewService reviewService;
    private final DibService dibService;
    private final IngredientService ingredientService;
    private final OrderHistoryService orderHistoryService;

    public CombPostController(CombService combService, CombPostService combPostService, UserService userService, MenuService menuService, S3Service s3Service, ReviewService reviewService, DibService dibService, IngredientService ingredientService, OrderHistoryService orderHistoryService) {
        this.combService = combService;
        this.combPostService = combPostService;
        this.userService = userService;
        this.menuService = menuService;
        this.s3Service = s3Service;
        this.reviewService = reviewService;
        this.dibService = dibService;
        this.ingredientService = ingredientService;
        this.orderHistoryService = orderHistoryService;
    }


    @ApiOperation(value = "조합 생성", notes = "주문 시 기존에 없는 조합일 경우 해당 조합을 저장한다.", httpMethod = "POST")
    @PostMapping
    @Transactional
    public SuccessResponseResult createComb(@RequestBody CombDto combination) {

        combService.save(combination);

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

    @ApiOperation(value = "메뉴로 게시글 목록 조회", notes = "해당하는 메뉴의 게시글 목록을 조회한다.", httpMethod = "GET")
    @GetMapping("/menu/{menuId}")
    public SuccessResponseResult getPostsByMenu(@PathVariable String menuId) {

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

    @ApiOperation(value = "Best 게시글 조회", notes = "Best 게시글의 정보를 조회한다.\n좋아요 가장 많은 게시물, 같을 시 별점으로", httpMethod = "GET")
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


    @ApiOperation(value = "정렬 기준에 따라 게시글 목록 조회", notes = "선택한 정렬 기준에 따라 게시글 목록을 조회한다.\n0 : 별점순\n1 : 최신순", httpMethod = "GET")
    @GetMapping("/order/{orderNo}")
    public SuccessResponseResult getPostsOrderBy(@PathVariable int orderNo) {

        List<CombPostResponse.PostResponse> posts = new ArrayList<>();
        List<CombinationPost> list = new ArrayList<>();

        // 0 : 별점순
        if(orderNo == 0)
            list = combPostService.findAllByOrderByScoreAvgDesc();
        // 1 : 최신순
        else if (orderNo == 1)
            list = combPostService.findAllByOrderByCreatedAtDesc();

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


    @ApiOperation(value = "게시글 찜 등록/삭제", notes = "찜을 한 상태면 찜 삭제, 찜을 하지 않은 상태면 찜을 등록한다.", httpMethod = "PUT")
    @PutMapping("/dib")
    @Transactional
    public SuccessResponseResult createCombPost(@RequestParam int combPostId, @RequestParam int userId) {

        Dib dib = dibService.findByCombinationPost_CombinationPostIdAndUser_UserId(combPostId, userId);
        CombinationPost post = combPostService.findByCombinationPostId(combPostId);

        // 아예 데이터가 없으면 생성, 게시글 좋아요 수 ++
        if(dib == null) {
            Dib newdib = new Dib();
            User user = userService.getUserByUserId(userId);

//            newdib.setCombinationPostId(combPostId);
            newdib.setCombinationPost(post);
            newdib.setUser(user);
            dibService.save(newdib);
            combPostService.likescntUpdate(post, post.getLikesCnt()+1);
        }

        // 데이터 있고 state가 true인 경우, 게시글 좋아요 수 --
        else if(dib.isState()) {
            dibService.stateUpdate(dib, false);
            combPostService.likescntUpdate(post, post.getLikesCnt()-1);
        }
        // 데이터 있고 state가 false인 경우, 게시글 좋아요 수 ++
        else if(!dib.isState()) {
            dibService.stateUpdate(dib, true);
            combPostService.likescntUpdate(post, post.getLikesCnt()+1);
        }

        return new SuccessResponseResult();
    }


    @ApiOperation(value = "게시글 통계 갱신", notes = "하루에 한 번씩 모든 게시글에 대한 통계를 갱신하여 저장한다.", httpMethod = "GET")
    @GetMapping("/statistics")
    @Scheduled(cron = "0 0 12 * * *")
    @Async
    public void updatePostStatistics() throws JsonProcessingException {

        List<CombinationPost> posts = combPostService.findAllByOrderByCreatedAtDesc();

        for(int i = 0; i < posts.size(); i++) {
            // 저장할 통계 데이터
            StatisticsDto statistics = new StatisticsDto();
            StatisticsDto.Gender gender = new StatisticsDto.Gender();
            StatisticsDto.Age age = new StatisticsDto.Age();
            StatisticsDto.Subti subti = new StatisticsDto.Subti();

            // 통계 저장할 게시글
            CombinationPost curPost = posts.get(i);

            List<OrderHistory> orders = orderHistoryService.findAllByCombination_CombinationId(curPost.getCombination().getCombinationId());

            for (int j = 0; j < orders.size(); j++) {
                OrderHistory curOrder = orders.get(j);

                LocalDate now = LocalDate.now();

                String user_gender = curOrder.getGender();
                int user_age = now.getYear() - curOrder.getBirthYear() + 1;
                String user_subti = curOrder.getSubti();

                // 성별 count
                if(user_gender.equals("0")) gender.setMale(gender.getMale()+1);
                else if(user_gender.equals("1")) gender.setFemale(gender.getFemale()+1);

                //나이 count
                if(user_age<20) age.setTeenager(age.getTeenager()+1);
                else if(user_age<30) age.setTwenties(age.getTwenties()+1);
                else if(user_age<40) age.setThirties(age.getThirties()+1);
                else if(user_age<50) age.setForties(age.getForties()+1);
                else if(user_age<60) age.setFifties(age.getFifties()+1);
                else if(user_age>=60) age.setSixties(age.getSixties()+1);

                // SUBTI count
                if(user_subti.equals("LSAH")) subti.setLSAH(subti.getLSAH()+1);
                else if(user_subti.equals("LSAM")) subti.setLSAM(subti.getLSAM()+1);
                else if(user_subti.equals("LSEH")) subti.setLSEH(subti.getLSEH()+1);
                else if(user_subti.equals("LSEM")) subti.setLSEM(subti.getLSEM()+1);
                else if(user_subti.equals("LCAH")) subti.setLCAH(subti.getLCAH()+1);
                else if(user_subti.equals("LCAM")) subti.setLCAM(subti.getLCAM()+1);
                else if(user_subti.equals("LCEH")) subti.setLCEH(subti.getLCEH()+1);
                else if(user_subti.equals("LCEM")) subti.setLCEM(subti.getLCEM()+1);
                else if(user_subti.equals("ISAH")) subti.setISAH(subti.getISAH()+1);
                else if(user_subti.equals("ISAM")) subti.setISAM(subti.getISAM()+1);
                else if(user_subti.equals("ISEH")) subti.setISEH(subti.getISEH()+1);
                else if(user_subti.equals("ISEM")) subti.setISEM(subti.getISEM()+1);
                else if(user_subti.equals("ICAH")) subti.setICAH(subti.getICAH()+1);
                else if(user_subti.equals("ICAM")) subti.setICAM(subti.getICAM()+1);
                else if(user_subti.equals("ICEH")) subti.setICEH(subti.getICEH()+1);
                else if(user_subti.equals("ICEM")) subti.setICEM(subti.getICEM()+1);
            }

            statistics.setGender(gender);
            statistics.setAge(age);
            statistics.setSubti(subti);

            // object를 json string 형태로 변환
            ObjectMapper objectMapper = new ObjectMapper();
            String statisticsJson = objectMapper.writeValueAsString(statistics);

            // 게시글에 통계 저장
            combPostService.statisticsUpdate(curPost, statisticsJson);
        }

    }
}


