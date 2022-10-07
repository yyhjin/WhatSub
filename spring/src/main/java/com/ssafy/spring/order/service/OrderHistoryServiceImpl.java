package com.ssafy.spring.order.service;

import com.ssafy.spring.order.entity.OrderHistory;
import com.ssafy.spring.order.repository.OrderHistoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderHistoryServiceImpl implements OrderHistoryService {

    private final OrderHistoryRepository orderHistoryRepository;

    public OrderHistoryServiceImpl(OrderHistoryRepository orderHistoryRepository) {
        this.orderHistoryRepository = orderHistoryRepository;
    }

    public List<OrderHistory> findAllByCombination_CombinationId(String combId) {
        return orderHistoryRepository.findAllByCombination_CombinationId(combId);
    }


}
