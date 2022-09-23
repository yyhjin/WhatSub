package com.ssafy.spring.user.controller;

import com.ssafy.spring.SuccessResponseResult;
import com.ssafy.spring.comb.entity.Combination;
import com.ssafy.spring.user.dto.UserRequest;
import com.ssafy.spring.user.dto.UserResponse;
import com.ssafy.spring.user.entity.Dib;
import com.ssafy.spring.user.entity.User;
import com.ssafy.spring.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "user-controller", tags={"user-controller"})
@RestController
@RequestMapping("/whatsub/v1/user")
//@CrossOrigin(origins = "https://j7a105.p.ssafy.io")
public class UserController {

    @Autowired
    private UserService UserService;

    @ApiOperation(value = "일반 회원가입", notes="회원가입에 성공하면 success, 아니면 fail", httpMethod = "POST")
    @PostMapping("/signup")
    public SuccessResponseResult signUp(@RequestBody UserRequest.SignUpRequest request){
        User user = new User();
        UserService.save(user);
        return new SuccessResponseResult();
    }

    @ApiOperation(value = "일반 로그인", notes="로그인에 성공하면 username 반환", httpMethod = "POST")
    @PostMapping("/login")
    public SuccessResponseResult login(@RequestBody UserRequest.LoginRequest request){


        return new SuccessResponseResult();
    }

    @ApiOperation(value = "유저 정보 조회", notes="유저 정보 조회에 성공하면 success와 data, 실패하면 fail", httpMethod = "GET")
    @GetMapping("/{userName}")
    public SuccessResponseResult getUser(@PathVariable String userName){
        User user = UserService.getUserByUserName(userName);
        return new SuccessResponseResult(user);
    }


    @ApiOperation(value = "중복 닉네임 검사", notes="이미 등록된 이름이면 false, 아니면 true", httpMethod = "GET")
    @GetMapping("/check/{userName}")
    public SuccessResponseResult checkUserName(@PathVariable String userName){
        boolean isDuplicate = UserService.existsByUserName(userName);
        return new SuccessResponseResult(isDuplicate);
    }

    @ApiOperation(value = "찜목록과 작성한 꿀조합 조회", notes="찜목록과 작성한 꿀조합 조회", httpMethod = "POST")
    @PostMapping("/{userName}/list")
    public SuccessResponseResult getDibNcombList(@PathVariable String userName){
        User user = UserService.getUserByUserName(userName);
        List<Dib> dibList = UserService.getDibsByUserAndStateIsTrue(user);
        List<Combination> combinationList = null;

        UserResponse.GetDibNcombListResponse response = new UserResponse.GetDibNcombListResponse(dibList, combinationList);
        return new SuccessResponseResult(response);
    }

    @ApiOperation(value = "subti 등록", notes="subti 결과를 DB에 등록", httpMethod = "POST")
    @PostMapping("subti")
    public SuccessResponseResult setSubti(@RequestBody UserRequest.GetSubtiRequest request) {
        int userId = request.getUserId();
        User user = UserService.getUserByUserId(userId);

        String subti = request.getSubti();
        user.setSubti(subti);
        UserService.save(user);
        return new SuccessResponseResult();
    }

    @ApiOperation(value = "제외 재료 등록", notes="등록이 완료되면 success, 아니면 fail", httpMethod = "POST")
    @PostMapping("/{userName}/exclude")
    public SuccessResponseResult excludeIngred(@RequestBody UserRequest.ExcludeRequest request){

        return new SuccessResponseResult();
    }
}
