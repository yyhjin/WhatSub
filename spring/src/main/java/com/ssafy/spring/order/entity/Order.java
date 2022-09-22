package com.ssafy.spring.order.entity;

import com.ssafy.spring.user.entity.User;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="branch_id")
    private Branch branch;

    @NotBlank
    private int orderPrice;

    @NotBlank
    private Date orderedAt;

}
