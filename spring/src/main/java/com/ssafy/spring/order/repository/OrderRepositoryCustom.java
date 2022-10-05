package com.ssafy.spring.order.repository;

import com.ssafy.spring.order.dto.OrderResponse;
import com.ssafy.spring.user.entity.User;

import java.util.List;

public interface OrderRepositoryCustom {
    List<OrderResponse.orderDto> findOrderHistory(User user);
    List<OrderResponse.orderDto> findOrderInfo(int orderId);
}
