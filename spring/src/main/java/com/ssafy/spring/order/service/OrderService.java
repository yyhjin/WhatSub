package com.ssafy.spring.order.service;

import com.ssafy.spring.order.dto.BranchDto;
import com.ssafy.spring.order.dto.OrderRequest;
import com.ssafy.spring.order.dto.OrderResponse;

import java.util.List;

public interface OrderService {
    BranchDto getStoreInfo(int storeId);
    List<BranchDto> getStores(float minlat, float maxlat, float minlng, float maxlng);
    List<OrderResponse.MenuDto> getMenuList();
    List<OrderResponse.IngredientDto> getIngredientList();
    OrderResponse.orderDto order(OrderRequest.OrderDto orderRequest);
    List<OrderResponse.orderDto> getOrderHistory(String userName);
}
