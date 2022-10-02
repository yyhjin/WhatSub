package com.ssafy.spring.order.service;

import com.ssafy.spring.order.dto.BranchDto;
import com.ssafy.spring.order.dto.OrderRequest;
import com.ssafy.spring.order.dto.OrderResponse;
import com.ssafy.spring.order.entity.OrderHistory;

import java.util.List;

public interface OrderHistoryService {
    List<OrderHistory> findAllByCombination_CombinationId(String combId);
}
