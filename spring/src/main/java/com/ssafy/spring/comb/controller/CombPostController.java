package com.ssafy.spring.comb.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssafy.spring.SuccessResponseResult;
import com.ssafy.spring.comb.dto.*;
import com.ssafy.spring.comb.entity.Combination;
import com.ssafy.spring.comb.entity.CombinationPost;
import com.ssafy.spring.comb.entity.Ingredient;
import com.ssafy.spring.comb.entity.Menu;
import com.ssafy.spring.comb.service.*;
import com.ssafy.spring.order.dto.OrderResponse;
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
import java.util.*;
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


    @ApiOperation(value = "게시판 등록 여부", notes = "해당 조합이 꿀조합 게시판에 있는지 확인한다.\n있으면 해당 게시글 번호 반환 / 없으면 해당 조합 정보 반환", httpMethod = "GET")
    @GetMapping("/exist/{combinationId}")
    public SuccessResponseResult checkPostExist(@PathVariable String combinationId) {

        CombinationPost post = combPostService.findByCombination_CombinationId(combinationId);
        int postId;

        if(post == null) {
            CombDto combDto = new CombDto(combService.findByCombinationId(combinationId));
            return new SuccessResponseResult(combDto);
        }
        else {
            postId = post.getCombinationPostId();
            return new SuccessResponseResult(postId);
        }
    }


    @ApiOperation(value = "꿀조합 게시글 등록", notes = "꿀조합 게시판에 글을 등록한다.", httpMethod = "POST")
    @PostMapping("/board")
    //@Transactional
    public SuccessResponseResult createCombPost(@RequestPart(value = "combPostRequest") CombPostRequest combPostRequest, @RequestPart(value = "file", required = false) MultipartFile file) {

        Combination comb = combService.findByCombinationId(combPostRequest.getCombinationId());
        User user = userService.getUserByUserId(combPostRequest.getUserId());

        String imgurl;
        if(Objects.isNull(file)) {
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
    @GetMapping("/{combinationPostId}/{userId}")
    public SuccessResponseResult getPostDetail(@PathVariable int combinationPostId, @PathVariable int userId) throws JsonProcessingException {

        CombPostResponse.PostDetailResponse response = new CombPostResponse.PostDetailResponse();

        CombinationPost post = combPostService.findByCombinationPostId(combinationPostId);


        response.setCombinationPostId(combinationPostId);
        response.setCombination(post.getCombination());
        response.setCombName(post.getCombName());
        response.setContent(post.getContent());
        response.setCreatedAt(post.getCreatedAt());
        response.setLikesCnt(post.getLikesCnt());
        response.setImgUrl(post.getImgUrl());
        response.setScoreAvg(post.getScoreAvg());

        // Json string -> Object로 변환
        if(post.getStatistics() != null) {
            String statistics = post.getStatistics();
            ObjectMapper objectMapper = new ObjectMapper();
            StatisticsDto statisticsDto = objectMapper.readValue(statistics, StatisticsDto.class);
            response.setStatistics(statisticsDto);
        }
        else {
            response.setStatistics(new StatisticsDto());
        }

        // 메뉴 정보
        String menuId = post.getCombination().getCombinationId().substring(0,1);
        Menu menu = menuService.getMenuByMenuId(menuId);
        response.setMenuName(menu.getMenuName());

        // 재료 정보
        List<IngredientDto.ingredientResponse> ingredients = new ArrayList<>();

        String list = post.getCombination().getCombinationId().substring(1);
        for (int i = 0, j = 0; j < list.length()/2; i += 2, j++) {
            IngredientDto.ingredientResponse ingredientResponse = new IngredientDto.ingredientResponse();
            String ingredientId = list.substring(i, i+2);
            Ingredient in = ingredientService.findByIngredientId(ingredientId);
            ingredientResponse.setCategory(in.getCategory());
            ingredientResponse.setName(in.getName());
            ingredients.add(ingredientResponse);
        }

        response.setIngredients(ingredients);


        // 리뷰
        List<Review> reviews = reviewService.getReviewList(combinationPostId);
        List<ReviewResponse.ResponseDto> reviewList = reviews.stream()
                .map(Review::EntityToDto)
                .collect(Collectors.toList());

        response.setReviews(reviewList);

        // 찜 여부
        Dib dib = dibService.findByCombinationPost_CombinationPostIdAndUser_UserId(post.getCombinationPostId(), userId);
        if(dib == null) response.setDib(0);
        else response.setDib(1);

        return new SuccessResponseResult(response);
    }


    @ApiOperation(value = "게시글 재료 조회", notes = "해당 게시글의 재료 정보들을 조회한다.", httpMethod = "GET")
    @GetMapping("/{combinationPostId}")
    public SuccessResponseResult getPostIngredients(@PathVariable int combinationPostId) throws JsonProcessingException {

        List<OrderResponse.IngredientDto> response = new ArrayList<>();

        CombinationPost post = combPostService.findByCombinationPostId(combinationPostId);

        String list = post.getCombination().getCombinationId().substring(1);
        for (int i = 0, j = 0; j < list.length()/2; i += 2, j++) {
            String ingredientId = list.substring(i, i+2);
            OrderResponse.IngredientDto ingredientResponse = new OrderResponse.IngredientDto(ingredientService.findByIngredientId(ingredientId));
            response.add(ingredientResponse);
        }

        return new SuccessResponseResult(response);
    }


    @ApiOperation(value = "메뉴로 게시글 목록 조회", notes = "해당하는 메뉴의 게시글 목록을 조회한다.", httpMethod = "GET")
    @GetMapping("/menu/{menuId}/{userId}")
    public SuccessResponseResult getPostsByMenu(@PathVariable String menuId, @PathVariable int userId) {

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

            // 메뉴 정보
            Menu menu = menuService.getMenuByMenuId(menuId);
            response.setMenuName(menu.getMenuName());

            // 재료 정보
            List<IngredientDto.ingredientResponse> ingredients = new ArrayList<>();

            String ingreList = current.getCombination().getCombinationId().substring(1);
            for (int k = 0, j = 0; j < ingreList.length()/2; k += 2, j++) {
                IngredientDto.ingredientResponse ingredientResponse = new IngredientDto.ingredientResponse();
                String ingredientId = ingreList.substring(k, k+2);
                Ingredient in = ingredientService.findByIngredientId(ingredientId);
                ingredientResponse.setCategory(in.getCategory());
                ingredientResponse.setName(in.getName());
                ingredients.add(ingredientResponse);
            }

            response.setIngredients(ingredients);

            // 리뷰
            List<Review> reviews = reviewService.getReviewList(current.getCombinationPostId());
            response.setReviewCnt(reviews.size());

            // 찜 여부
            Dib dib = dibService.findByCombinationPost_CombinationPostIdAndUser_UserId(current.getCombinationPostId(), userId);
            if(dib == null) response.setDib(0);
            else response.setDib(1);

            posts.add(response);
        }

        return new SuccessResponseResult(posts);
    }

    @ApiOperation(value = "Best 게시글 조회", notes = "Best 게시글의 정보를 조회한다.\n좋아요 가장 많은 게시물, 같을 시 별점으로", httpMethod = "GET")
    @GetMapping("/best/{userId}")
    public SuccessResponseResult getBestPost(@PathVariable int userId) {

        CombPostResponse.PostResponse response = new CombPostResponse.PostResponse();

        CombinationPost post = combPostService.findTopByOrderByLikesCntDescScoreAvgDesc();

        response.setCombination(post.getCombination());
        response.setCombName(post.getCombName());
        response.setCombinationPostId(post.getCombinationPostId());
        response.setCreatedAt(post.getCreatedAt());
        response.setImgUrl(post.getImgUrl());
        response.setLikesCnt(post.getLikesCnt());
        response.setScoreAvg(post.getScoreAvg());

        // 메뉴 정보
        String menuId = post.getCombination().getCombinationId().substring(0,1);
        Menu menu = menuService.getMenuByMenuId(menuId);
        response.setMenuName(menu.getMenuName());

        // 재료 정보
        List<IngredientDto.ingredientResponse> ingredients = new ArrayList<>();

        String list = post.getCombination().getCombinationId().substring(1);
        for (int k = 0, j = 0; j < list.length()/2; k += 2, j++) {
            IngredientDto.ingredientResponse ingredientResponse = new IngredientDto.ingredientResponse();
            String ingredientId = list.substring(k, k+2);
            Ingredient in = ingredientService.findByIngredientId(ingredientId);
            ingredientResponse.setCategory(in.getCategory());
            ingredientResponse.setName(in.getName());
            ingredients.add(ingredientResponse);
        }

        response.setIngredients(ingredients);

        // 리뷰
        List<Review> reviews = reviewService.getReviewList(post.getCombinationPostId());
        response.setReviewCnt(reviews.size());

        // 찜 여부
        Dib dib = dibService.findByCombinationPost_CombinationPostIdAndUser_UserId(post.getCombinationPostId(), userId);
        if(dib == null) response.setDib(0);
        else response.setDib(1);

        return new SuccessResponseResult(response);
    }


    @ApiOperation(value = "정렬 기준에 따라 게시글 목록 조회", notes = "선택한 정렬 기준에 따라 게시글 목록을 조회한다.\n0 : 별점순\n1 : 최신순", httpMethod = "GET")
    @GetMapping("/order/{orderNo}/{userId}")
    public SuccessResponseResult getPostsOrderBy(@PathVariable int orderNo, @PathVariable int userId) {

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

            // 메뉴 정보
            String menuId = current.getCombination().getCombinationId().substring(0,1);
            Menu menu = menuService.getMenuByMenuId(menuId);
            response.setMenuName(menu.getMenuName());

            // 재료 정보
            List<IngredientDto.ingredientResponse> ingredients = new ArrayList<>();

            String ingreList = current.getCombination().getCombinationId().substring(1);
            for (int k = 0, j = 0; j < ingreList.length()/2; k += 2, j++) {
                IngredientDto.ingredientResponse ingredientResponse = new IngredientDto.ingredientResponse();
                String ingredientId = ingreList.substring(k, k+2);
                Ingredient in = ingredientService.findByIngredientId(ingredientId);
                ingredientResponse.setCategory(in.getCategory());
                ingredientResponse.setName(in.getName());
                ingredients.add(ingredientResponse);
            }

            response.setIngredients(ingredients);

            // 리뷰
            List<Review> reviews = reviewService.getReviewList(current.getCombinationPostId());
            response.setReviewCnt(reviews.size());

            // 찜 여부
            Dib dib = dibService.findByCombinationPost_CombinationPostIdAndUser_UserId(current.getCombinationPostId(), userId);
            if(dib == null) response.setDib(0);
            else response.setDib(1);

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
            Map<String, Integer> map = new HashMap<>();
            map.put("male", 0);
            map.put("female", 0);
            map.put("teenager", 0);
            map.put("twenties", 0);
            map.put("thirties", 0);
            map.put("forties", 0);
            map.put("fifties", 0);
            map.put("sixties", 0);
            map.put("lsah", 0);
            map.put("lsam", 0);
            map.put("lseh", 0);
            map.put("lsem", 0);
            map.put("lcah", 0);
            map.put("lcam", 0);
            map.put("lceh", 0);
            map.put("lcem", 0);
            map.put("isah", 0);
            map.put("isam", 0);
            map.put("iseh", 0);
            map.put("isem", 0);
            map.put("icah", 0);
            map.put("icam", 0);
            map.put("iceh", 0);
            map.put("icem", 0);


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
                if(user_gender.equals("0")) map.put("male", map.get("male")+1);
                else if(user_gender.equals("1")) map.put("female", map.get("female")+1);

                //나이 count
                if(user_age<20) map.put("teenager", map.get("teenager")+1);
                else if(user_age<30) map.put("twenties", map.get("twenties")+1);
                else if(user_age<40) map.put("thirties", map.get("thirties")+1);
                else if(user_age<50) map.put("forties", map.get("forties")+1);
                else if(user_age<60) map.put("fifties", map.get("fifties")+1);
                else if(user_age>=60) map.put("sixties", map.get("sixties")+1);

                // SUBTI count
                String subti = user_subti.toLowerCase();
                map.put(subti, map.get(subti)+1);

            }

            // map을 json string 형태로 변환
            ObjectMapper objectMapper = new ObjectMapper();
            String statisticsJson = objectMapper.writeValueAsString(map);

            // 게시글에 통계 저장
            combPostService.statisticsUpdate(curPost, statisticsJson);
        }

    }
}


