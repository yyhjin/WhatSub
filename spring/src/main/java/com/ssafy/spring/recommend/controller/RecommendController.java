package com.ssafy.spring.recommend.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssafy.spring.SuccessResponseResult;
import com.ssafy.spring.comb.entity.CombinationPost;
import com.ssafy.spring.comb.entity.Ingredient;
import com.ssafy.spring.comb.entity.Menu;
import com.ssafy.spring.comb.service.*;
import com.ssafy.spring.recommend.dto.IngredientDto;
import com.ssafy.spring.recommend.dto.RecommendRequest;
import com.ssafy.spring.recommend.dto.RecommendResponse;
import com.ssafy.spring.recommend.service.RecommendService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@Api(value = "메뉴 추천", tags={"recommend-controller"})
@RestController
@RequestMapping("/recommendation")
public class RecommendController {

    private final RecommendService recommendService;
    private final CombPostService combPostService;
    private final MenuService menuService;
    private final IngredientService ingredientService;

    public RecommendController(RecommendService recommendService, CombPostService combPostService, MenuService menuService, IngredientService ingredientService) {
        this.recommendService = recommendService;
        this.combPostService = combPostService;
        this.menuService = menuService;
        this.ingredientService = ingredientService;
    }


    @ApiOperation(value = "꿀조합 게시판 기반 추천 목록 조회", notes = "꿀조합 게시판에서 좋아요, 별점 순으로 30개를 뽑아 그 중 5개 꿀조합 목록을 반환한다.", httpMethod = "GET")
    @GetMapping("/postrank")
    public SuccessResponseResult getCombByPostRank() {

        List<RecommendResponse> responses = new ArrayList<>();

        // 꿀조합 게시판 상위 30개 목록 가져오기
        List<CombinationPost> posts = recommendService.findTop30ByOrderByLikesCntDescScoreAvgDesc();
        // 랜덤으로 정렬
        Collections.shuffle(posts);

        for (int i = 0; i < 5; i++) {
            RecommendResponse item = new RecommendResponse();
            CombinationPost post = posts.get(i);

            // 조합&꿀조합 정보
            item.setCombinationId(post.getCombination().getCombinationId());
            item.setCombinationPostId(post.getCombinationPostId());
            item.setCombName(post.getCombName());
            item.setContent(post.getContent());
            item.setLikesCnt(post.getLikesCnt());
            item.setScoreAvg(post.getScoreAvg());
            item.setKcal(post.getCombination().getKcal());
            item.setProtein(post.getCombination().getProtein());
            item.setSodium(post.getCombination().getSodium());
            item.setFat(post.getCombination().getFat());
            item.setSugar(post.getCombination().getSugar());
            item.setAllergies(post.getCombination().getAllergies());
            item.setPrice(post.getCombination().getPrice());

            // 메뉴 정보
            String menuid = post.getCombination().getCombinationId().substring(0,1);
            Menu menu = menuService.getMenuByMenuId(menuid);

            item.setMenuName(menu.getMenuName());
            item.setImgUrl(menu.getImgUrl());
            item.setIngredients(menu.getIngredients());
            item.setMenuDesc(menu.getMenuDesc());

            // 재료 정보
            List<IngredientDto> dtos = new ArrayList<>();
            String list = post.getCombination().getCombinationId().substring(1);
            for (int k = 0, j = 0; j < list.length()/2; k += 2, j++) {
                String sub = list.substring(k, k+2);
                Ingredient ingredientItem = ingredientService.findByIngredientId(sub);
                IngredientDto dto = new IngredientDto();
                dto.setName(ingredientItem.getName());
                dto.setCategory(ingredientItem.getCategory());
                dto.setImgUrl(ingredientItem.getImgUrl());
                dto.setPrice(ingredientItem.getPrice());

                dtos.add(dto);
            }
            item.setIngredient(dtos);

            responses.add(item);

        }

        return new SuccessResponseResult(responses);
    }


    @ApiOperation(value = "영양정보로 추천 꿀조합 목록 조회", notes = "영양정보 범위에 해당하는 꿀조합 목록을 조회한다.", httpMethod = "POST")
    @PostMapping("/nutrition")
    public SuccessResponseResult getCombByNutrition(@RequestBody RecommendRequest request) {

        List<RecommendResponse> responses = new ArrayList<>();

        List<CombinationPost> posts = recommendService.findAllByNutrition(request);

        for (int i = 0; i < posts.size(); i++) {
            RecommendResponse item = new RecommendResponse();
            CombinationPost post = posts.get(i);

            // 조합&꿀조합 정보
            item.setCombinationId(post.getCombination().getCombinationId());
            item.setCombinationPostId(post.getCombinationPostId());
            item.setCombName(post.getCombName());
            item.setContent(post.getContent());
            item.setLikesCnt(post.getLikesCnt());
            item.setScoreAvg(post.getScoreAvg());
            item.setKcal(post.getCombination().getKcal());
            item.setProtein(post.getCombination().getProtein());
            item.setSodium(post.getCombination().getSodium());
            item.setFat(post.getCombination().getFat());
            item.setSugar(post.getCombination().getSugar());
            item.setAllergies(post.getCombination().getAllergies());
            item.setPrice(post.getCombination().getPrice());

            // 메뉴 정보
            String menuid = post.getCombination().getCombinationId().substring(0,1);
            Menu menu = menuService.getMenuByMenuId(menuid);

            item.setMenuName(menu.getMenuName());
            item.setImgUrl(menu.getImgUrl());
            item.setIngredients(menu.getIngredients());
            item.setMenuDesc(menu.getMenuDesc());

            // 재료 정보
            List<IngredientDto> dtos = new ArrayList<>();
            String list = post.getCombination().getCombinationId().substring(1);
            for (int k = 0, j = 0; j < list.length()/2; k += 2, j++) {
                String sub = list.substring(k, k+2);
                Ingredient ingredientItem = ingredientService.findByIngredientId(sub);
                IngredientDto dto = new IngredientDto();
                dto.setName(ingredientItem.getName());
                dto.setCategory(ingredientItem.getCategory());
                dto.setImgUrl(ingredientItem.getImgUrl());
                dto.setPrice(ingredientItem.getPrice());

                dtos.add(dto);
            }
            item.setIngredient(dtos);

            responses.add(item);

        }

        return new SuccessResponseResult(responses);
    }


    @ApiOperation(value = "SUBTI 기반 추천 목록 조회", notes = "사용자와 같은 SUBTI를 가진 사람들이 가장 많이 먹은 조합을 조회한다.", httpMethod = "GET")
    @GetMapping("/subti/{subti}")
    public SuccessResponseResult getCombBySubti(@PathVariable String subti) throws JsonProcessingException {

        // 게시판 전체 목록 가져오기
        List<CombinationPost> posts = combPostService.findAllByOrderByCreatedAtDesc();

        // 해당 subti가 가장 많이 먹은 조합 인덱스와 횟수
        int maxCnt = 0;
        int maxIdx = -1;

        String lower_subti = subti.toLowerCase();
        for (int i = 0; i < posts.size(); i++) {
            CombinationPost post = posts.get(i);

            // json string을 Map으로 매핑
            String statistics = post.getStatistics();
            if(statistics == null) continue;

            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Integer> map = objectMapper.readValue(statistics, Map.class);

            int subtiCnt = map.get(lower_subti);
            if(subtiCnt > maxCnt) {
                maxCnt = subtiCnt;
                maxIdx = i;
            }

        }

        // 해당 subti가 가장 많이 주문한 꿀조합
        CombinationPost maxPost = posts.get(maxIdx);
        RecommendResponse response = new RecommendResponse();

        // 조합&꿀조합 정보
        response.setCombinationId(maxPost.getCombination().getCombinationId());
        response.setCombinationPostId(maxPost.getCombinationPostId());
        response.setCombName(maxPost.getCombName());
        response.setContent(maxPost.getContent());
        response.setLikesCnt(maxPost.getLikesCnt());
        response.setScoreAvg(maxPost.getScoreAvg());
        response.setKcal(maxPost.getCombination().getKcal());
        response.setProtein(maxPost.getCombination().getProtein());
        response.setSodium(maxPost.getCombination().getSodium());
        response.setFat(maxPost.getCombination().getFat());
        response.setSugar(maxPost.getCombination().getSugar());
        response.setAllergies(maxPost.getCombination().getAllergies());
        response.setPrice(maxPost.getCombination().getPrice());

        // 메뉴 정보
        String menuid = maxPost.getCombination().getCombinationId().substring(0,1);
        Menu menu = menuService.getMenuByMenuId(menuid);

        response.setMenuName(menu.getMenuName());
        response.setImgUrl(menu.getImgUrl());
        response.setIngredients(menu.getIngredients());
        response.setMenuDesc(menu.getMenuDesc());

        // 재료 정보
        List<IngredientDto> dtos = new ArrayList<>();
        String list = maxPost.getCombination().getCombinationId().substring(1);
        for (int k = 0, j = 0; j < list.length()/2; k += 2, j++) {
            String sub = list.substring(k, k+2);
            Ingredient ingredientItem = ingredientService.findByIngredientId(sub);
            IngredientDto dto = new IngredientDto();
            dto.setName(ingredientItem.getName());
            dto.setCategory(ingredientItem.getCategory());
            dto.setImgUrl(ingredientItem.getImgUrl());
            dto.setPrice(ingredientItem.getPrice());

            dtos.add(dto);
        }
        response.setIngredient(dtos);

        return new SuccessResponseResult(response);
    }


}


