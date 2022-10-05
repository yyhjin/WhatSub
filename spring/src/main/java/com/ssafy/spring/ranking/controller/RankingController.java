package com.ssafy.spring.ranking.controller;

import com.ssafy.spring.SuccessResponseResult;
import com.ssafy.spring.ranking.service.RankingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "ranking-controller", tags={"ranking-controller"})
@RestController
@RequestMapping("/ranking")
public class RankingController {

    @Autowired
    private RankingService rankingService;

    @ApiOperation(value = "월별 랭킹 정보 조회", notes="각 메뉴당 유저 월별 랭킹을 반환한다.", httpMethod = "GET")
    @GetMapping("")
    public SuccessResponseResult getMonthlyRanking() {
        return new SuccessResponseResult(rankingService.getMonthlyRanking());
    }

}
