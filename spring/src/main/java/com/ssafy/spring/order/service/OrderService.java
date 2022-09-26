package com.ssafy.spring.order.service;

import com.ssafy.spring.order.dto.BranchDto;
import com.ssafy.spring.order.dto.OrderDto;

import java.util.List;

public interface OrderService {
    List<BranchDto> getStores(float minlat, float maxlat, float minlng, float maxlng);

    OrderDto.responseDto order(OrderDto.requestDto orderRequestDto);
}
