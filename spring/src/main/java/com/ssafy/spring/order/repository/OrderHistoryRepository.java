package com.ssafy.spring.order.repository;

import com.ssafy.spring.order.entity.OrderHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderHistoryRepository extends JpaRepository<OrderHistory, Integer> {

    List<OrderHistory> findAllByCombination_CombinationId(String combId);
}
