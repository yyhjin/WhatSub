package com.ssafy.spring.order.controller;

import com.ssafy.spring.SuccessResponseResult;
import com.ssafy.spring.order.dto.OrderRequest;
import com.ssafy.spring.order.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(value = "order-controller", tags={"order-controller"})
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @ApiOperation(value = "지점 정보 조회", notes="해당 지역의 지점을 리스트를 반환한다.", httpMethod = "GET")
    @GetMapping("/store")
    public SuccessResponseResult getStores(float minlat, float maxlat, float minlng, float maxlng) {
        return new SuccessResponseResult(orderService.getStores(minlat, maxlat, minlng, maxlng));
    }

    @ApiOperation(value = "지점 정보 조회", notes="해당 지역의 지점을 리스트를 반환한다.", httpMethod = "GET")
    @GetMapping("/store/{storeId}")
    public SuccessResponseResult getStoreInfo(int storeId) {
        return new SuccessResponseResult(orderService.getStoreInfo(storeId));
    }

    @ApiOperation(value = "메뉴 정보 조회", notes="메뉴 리스트를 반환한다.", httpMethod = "GET")
    @GetMapping("/menu")
    public SuccessResponseResult getMenuList() {
        return new SuccessResponseResult(orderService.getMenuList());
    }

    @ApiOperation(value = "재료 정보 조회", notes="재료 리스트를 반환한다.", httpMethod = "GET")
    @GetMapping("/ingredient")
    public SuccessResponseResult getIngredientList() {
        return new SuccessResponseResult(orderService.getIngredientList());
    }

    @ApiOperation(value = "주문 생성", notes="주문 내용을 DB에 저장한다.", httpMethod = "POST")
    @PostMapping("/")
    public SuccessResponseResult order(@RequestBody OrderRequest.OrderDto orderRequest) {
        return new SuccessResponseResult(orderService.order(orderRequest));
    }

    @ApiOperation(value = "주문 내역 조회", notes="유저의 최근 주문 내역을 조회한다.", httpMethod = "GET")
    @GetMapping("/{userName}")
    public SuccessResponseResult getOrderHistory(@PathVariable String userName) {
        return new SuccessResponseResult(orderService.getOrderHistory(userName));
    }
}
