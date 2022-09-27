package com.ssafy.spring.comb.controller;

import com.ssafy.spring.comb.dto.CombDto;
import com.ssafy.spring.comb.dto.CombPostRequest;
import com.ssafy.spring.comb.entity.Combination;
import com.ssafy.spring.comb.entity.CombinationPost;
import com.ssafy.spring.comb.service.CombPostService;
import com.ssafy.spring.comb.service.CombService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Api(value = "꿀조합 게시판", tags={"combination post-controller"})
@RestController
@RequestMapping("/comb")
public class CombPostController {

    private final CombService combService;
    private final CombPostService combPostService;

    public CombPostController(CombService combService, CombPostService combPostService) {
        this.combService = combService;
        this.combPostService = combPostService;

    }


    @ApiOperation(value = "조합 생성", notes = "주문 시 기존에 없는 조합일 경우 해당 조합을 저장한다.", httpMethod = "POST")
    @PostMapping
    @Transactional
    public ResponseEntity<String> createComb(@RequestBody CombDto combination) {

        Combination newcomb = combService.save(combination);

        return new ResponseEntity(newcomb.getCombinationId(), HttpStatus.OK);
    }



    @ApiOperation(value = "꿀조합 게시글 등록", notes = "꿀조합 게시판에 글을 등록한다.", httpMethod = "POST")
    @PostMapping("/board")
    @Transactional
    public ResponseEntity<Integer> createCombPost(@RequestBody CombPostRequest postRequest) {

        Combination comb = combService.findByCombinationId(postRequest.getCombinationId());
        CombinationPost newPost = combPostService.save(comb, postRequest);

        return new ResponseEntity(newPost.getCombinationPostId(), HttpStatus.OK);
    }

}


