package com.ssafy.spring.order.repository;

import com.ssafy.spring.order.entity.Orders;
import com.ssafy.spring.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Orders, Integer>, OrderRepositoryCustom {
    List<Orders> findByUser(User user);
}
