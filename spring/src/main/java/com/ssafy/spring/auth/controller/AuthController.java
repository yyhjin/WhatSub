package com.ssafy.spring.auth.controller;

import com.ssafy.spring.SuccessResponseResult;
import com.ssafy.spring.auth.dto.AuthResponse;
import com.ssafy.spring.auth.dto.KakaoTokenInfo;
import com.ssafy.spring.auth.dto.KakaoUserInfo;
import com.ssafy.spring.auth.service.AuthService;
import com.ssafy.spring.user.entity.User;
import com.ssafy.spring.user.service.UserService;
import com.ssafy.spring.util.JWTUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController@Api(value = "auth-controller", tags={"auth-controller"})
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private UserService userService;

    @Autowired
    private JWTUtil jwtUtil;

    @ApiOperation(value = "카카오 로그인", notes="인가 코드를 주면 기존 유저는 1, 신규 유저는 회원가입 후 2 반환", httpMethod = "GET")
    @GetMapping("/login")
    public SuccessResponseResult kakakoLogin(@RequestParam String code, HttpServletResponse httpServletResponse){
        KakaoTokenInfo kakaoTokenInfo = authService.getTokenByCode(code);
        KakaoUserInfo kakaoUserInfo = authService.getUserByAccessToken(kakaoTokenInfo.getAccessToken());
        System.out.println(kakaoUserInfo);

        String authId = Long.toString(kakaoUserInfo.getId());
        User user;
        AuthResponse.LoginResponse loginResponse;

        // 기존 회원이면 로그인 시키고 1 리턴
        if(userService.existsByAuthId(authId)){
            user = userService.getUserByAuthId(authId);

            String accessToken = jwtUtil.createToken(user.getEmail());
            loginResponse = new AuthResponse.LoginResponse(user, 1, accessToken);
        }
        else { // 새 회원이면 회원가입 및 로그인 시키고 2 리턴
            user = User.builder()
                    .authId(Long.toString(kakaoUserInfo.getId()))
                    .userName(kakaoUserInfo.getNickname())
                    .profileImg(kakaoUserInfo.getProfileImage())
//                    .refreshToken(kakaoTokenInfo.getRefreshToken())
                    .build();
            userService.save(user);

            String accessToken = jwtUtil.createToken(user.getEmail());
            loginResponse = new AuthResponse.LoginResponse(user, 2, accessToken);
        }

        String refreshToken = "";
        Cookie cookie = new Cookie("refreshToken", refreshToken);
        cookie.setMaxAge(7*24*60*60); // 7일
        cookie.setHttpOnly(true); //브라우저에서만 접근할 수 있도록 설정
        cookie.setPath("/"); //모든 경로에서 접근 가능
        httpServletResponse.addCookie(cookie);

        return new SuccessResponseResult(loginResponse);
    }

}
