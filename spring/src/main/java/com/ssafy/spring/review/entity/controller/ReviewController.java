package com.ssafy.spring.review.entity.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "user-controller", tags={"user-controller"})
@RestController
public class ReviewController {
    @ApiOperation(value = "아이디 중복 검사", notes="판매자 아이디를 중복 검사한다. 중복이 안되면 true, 중복이면 false",httpMethod = "GET")
    @GetMapping("/idcheck/{customer_id}")
    public String IdCheck(String customerId) {
        return "whatsub";
    }
}
