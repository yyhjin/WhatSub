package com.ssafy.spring.auth.controller;

import com.ssafy.spring.SuccessResponseResult;
import com.ssafy.spring.auth.dto.AuthRequest;
import com.ssafy.spring.auth.dto.AuthResponse;
import com.ssafy.spring.auth.dto.KakaoTokenInfo;
import com.ssafy.spring.auth.dto.KakaoUserInfo;
import com.ssafy.spring.auth.repository.service.AuthService;
import com.ssafy.spring.user.entity.User;
import com.ssafy.spring.user.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@RestController@Api(value = "auth-controller", tags={"auth-controller"})
@RequestMapping("/whatsub/v1/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private UserService userService;

    @GetMapping("/kakao")
    public SuccessResponseResult kakakoCallback(@RequestParam String code, HttpServletResponse httpServletResponse){
        KakaoTokenInfo kakaoTokenInfo = authService.getTokenByCode(code);
        KakaoUserInfo kakaoUserInfo = authService.getUserByAccessToken(kakaoTokenInfo.getAccessToken());
        System.out.println(kakaoUserInfo);

        String authId = Long.toString(kakaoUserInfo.getId());
        User user;
        AuthResponse.LoginResponse loginResponse;

        // 기존 회원이면 로그인 시키고 1 리턴
        if(userService.existsByAuthId(authId)){
            user = userService.getUserByAuthId(authId);
            loginResponse = new AuthResponse.LoginResponse(user, 1);
            System.out.println("기존 유저 로그인");
        }
        else { // 새 회원이면 회원가입 및 로그인 시키고 2 리턴
            user = User.builder()
                    .authId(Long.toString(kakaoUserInfo.getId()))
                    .userName(kakaoUserInfo.getNickname())
                    .profileImg(kakaoUserInfo.getProfileImage())
//                    .refreshToken(kakaoTokenInfo.getRefreshToken())
                    .build();
            userService.save(user);
            System.out.println("새 유저 로그인");
            loginResponse = new AuthResponse.LoginResponse(user, 2);
        }


        try {
//            URLEncoder.encode(loginResponse.toString(), "UTF-8");

            Cookie cookie = new Cookie("user", URLEncoder.encode(loginResponse.toString(), "UTF-8"));
            cookie.setMaxAge(7*24*60*60); // 7일
            cookie.setHttpOnly(true); //브라우저에서만 접근할 수 있도록 설정
            cookie.setPath("/"); //모든 경로에서 접근 가능
            httpServletResponse.addCookie(cookie);

//            Cookie cookie = new Cookie("user", loginResponse.toString());
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }

//        return new SuccessResponseResult(httpServletResponse);
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
