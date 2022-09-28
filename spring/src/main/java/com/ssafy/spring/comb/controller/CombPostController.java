package com.ssafy.spring.comb.controller;

import com.ssafy.spring.comb.dto.CombDto;
import com.ssafy.spring.comb.dto.CombPostRequest;
import com.ssafy.spring.comb.entity.Combination;
import com.ssafy.spring.comb.entity.CombinationPost;
import com.ssafy.spring.comb.entity.Menu;
import com.ssafy.spring.comb.service.CombPostService;
import com.ssafy.spring.comb.service.CombService;
import com.ssafy.spring.comb.service.MenuService;
import com.ssafy.spring.comb.service.S3Service;
import com.ssafy.spring.user.entity.User;
import com.ssafy.spring.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@Api(value = "꿀조합 게시판", tags={"combination post-controller"})
@RestController
@RequestMapping("/comb")
public class CombPostController {

    private final CombService combService;
    private final CombPostService combPostService;
    private final UserService userService;
    private final MenuService menuService;
    private final S3Service s3Service;

    public CombPostController(CombService combService, CombPostService combPostService, UserService userService, MenuService menuService, S3Service s3Service) {
        this.combService = combService;
        this.combPostService = combPostService;
        this.userService = userService;
        this.menuService = menuService;
        this.s3Service = s3Service;
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
    public ResponseEntity<Integer> createCombPost(@RequestPart(value = "combPostRequest") CombPostRequest combPostRequest, @RequestPart(value = "file", required = false) MultipartFile file) {

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


        return new ResponseEntity(newPost.getCombinationPostId(), HttpStatus.OK);
    }

}


