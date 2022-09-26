package com.ssafy.spring.comb.entity;

import lombok.*;

import javax.persistence.*;


@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Combination {

    @Id
    private String combinationId;

    private float kcal;

    private float protein;

    private float sodium;

    private float fat;

    private float sugar;

    private String allergies;

    private int price;

    @Column(nullable = false)
    private String imgUrl;
}
