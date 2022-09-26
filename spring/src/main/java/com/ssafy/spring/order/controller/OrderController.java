package com.ssafy.spring.order.controller;

import com.ssafy.spring.SuccessResponseResult;
import com.ssafy.spring.order.dto.OrderDto;
import com.ssafy.spring.order.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "order-controller", tags={"order-controller"})
@RestController
@RequestMapping("/whatsub/v1/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @ApiOperation(value = "지점 정보 조회", notes="해당 지역의 지점을 리스트를 반환한다.", httpMethod = "GET")
    @GetMapping("/store")
    public SuccessResponseResult getStores(float minlat, float maxlat, float minlng, float maxlng) {
        return new SuccessResponseResult(orderService.getStores(minlat, maxlat, minlng, maxlng));
    }

//    @ApiOperation(value = "주문 생성", notes="주문 내용을 DB에 저장한다.", httpMethod = "POST")
//    @PostMapping("/")
//    public SuccessResponseResult order(OrderDto.requestDto orderRequestDto) {
//        return new SuccessResponseResult(orderService.order(orderRequestDto));
//    }
}
