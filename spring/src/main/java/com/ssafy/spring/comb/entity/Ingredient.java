package com.ssafy.spring.comb.entity;

import lombok.*;

import javax.persistence.*;


@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ingredient {

    @Id
    private String ingredientId;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String imgUrl;

    @Column(nullable = true)
    private float kcal;

    @Column(nullable = true)
    private float protein;

    @Column(nullable = true)
    private float sodium;

    @Column(nullable = true)
    private float fat;

    @Column(nullable = true)
    private float sugar;

    private String allergies;

    private int price;

}
