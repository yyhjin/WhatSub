package com.ssafy.spring.auth.controller;

import com.ssafy.spring.SuccessResponseResult;
import com.ssafy.spring.auth.dto.AuthRequest;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

@RestController@Api(value = "auth-controller", tags={"auth-controller"})
@RequestMapping("/whatsub/v1/auth")
public class AuthController {

    @GetMapping("/kakao")
    public SuccessResponseResult kakakoCallback(@RequestParam String code){
        System.out.println(code); //프론트에서 받아올 코드
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
