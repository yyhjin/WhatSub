package com.ssafy.spring.comb.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Menu {

    @Id
    private String menuId;

    @Column(nullable = false)
    private String imgUrl;

    @Column(nullable = false)
    private String menuName;

    @Column(nullable = false)
    private String ingredients;

    @Column(nullable = false)
    private String menuDesc;

    private String allergies;

    private int price;

    private float kcal;

    private float protein;

    private float sodium;

    private float fat;

    private float sugar;

    private int soft;

    private int salty;

    private int chewy;

    private int sour;

    private int sweet;

    private int nutty;

    private int spicy;

    private int bland;
}
