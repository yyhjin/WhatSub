package com.ssafy.spring.auth.controller;

import com.ssafy.spring.SuccessResponseResult;
import com.ssafy.spring.auth.dto.AuthRequest;
import com.ssafy.spring.auth.dto.KakaoTokenInfo;
import com.ssafy.spring.auth.dto.KakaoUserInfo;
import com.ssafy.spring.auth.repository.service.AuthService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController@Api(value = "auth-controller", tags={"auth-controller"})
@RequestMapping("/whatsub/v1/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @GetMapping("/kakao")
    public SuccessResponseResult kakakoCallback(@RequestParam String code){
        KakaoTokenInfo kakaoTokenInfo = authService.getTokenByCode(code);
        KakaoUserInfo kakaoUserInfo = authService.getUserByAccessToken(kakaoTokenInfo.getAccessToken());

        System.out.println(kakaoUserInfo);

        return new SuccessResponseResult();
    }



    @PostMapping("/login")
    public SuccessResponseResult login(){
        return new SuccessResponseResult();
    }

    @GetMapping("/usercheck")
    public SuccessResponseResult userCheck(@RequestBody AuthRequest.UserCheckRequest request){
        String code = request.getCode();




        return new SuccessResponseResult();
    }
}
