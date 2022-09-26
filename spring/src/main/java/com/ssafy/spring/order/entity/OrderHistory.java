package com.ssafy.spring.order.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class OrderHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderHistoryId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="order_id")
    private Orders order;

    private int count;
}
