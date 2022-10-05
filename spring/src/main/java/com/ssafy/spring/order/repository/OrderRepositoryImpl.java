package com.ssafy.spring.order.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.ssafy.spring.comb.entity.Combination;
import com.ssafy.spring.order.dto.OrderResponse;
import com.ssafy.spring.order.entity.Orders;
import com.ssafy.spring.user.entity.User;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;

import static com.querydsl.core.group.GroupBy.groupBy;
import static com.querydsl.core.group.GroupBy.list;
import static com.ssafy.spring.comb.entity.QCombination.combination;
import static com.ssafy.spring.order.entity.QOrderHistory.orderHistory;
import static com.ssafy.spring.order.entity.QOrders.orders;

@RequiredArgsConstructor
public class OrderRepositoryImpl implements OrderRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<OrderResponse.orderDto> findOrderHistory(User user) {
        return queryFactory
                .from(orderHistory)
                .join(orderHistory.order, orders)
                .join(orderHistory.combination, combination)
                .where(orders.user.eq(user))
                .orderBy(orders.orderedAt.desc())
                .transform(groupBy(orders.orderId).list(Projections.constructor(OrderResponse.orderDto.class, orders, list(Projections.constructor(OrderResponse.CombinationDto.class, combination.combinationId, combination.allergies, orderHistory.count)))));

    }

    @Override
    public List<OrderResponse.orderDto> findOrderInfo(int orderId) {
        return queryFactory
                .from(orderHistory)
                .join(orderHistory.order, orders)
                .join(orderHistory.combination, combination)
                .where(orders.orderId.eq(orderId))
                .transform(groupBy(orders.orderId).list(Projections.constructor(OrderResponse.orderDto.class, orders, list(Projections.constructor(OrderResponse.CombinationDto.class, combination.combinationId, combination.allergies, orderHistory.count)))));
    }
}
