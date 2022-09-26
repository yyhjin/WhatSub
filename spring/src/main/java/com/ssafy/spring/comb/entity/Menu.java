package com.ssafy.spring.comb.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int menuId;

    @NotBlank
    private String imgUrl;

    @NotBlank
    private String menuName;

    private String ingredients;

    private String menuDesc;

    private String allergies;

    private int price;

    private int kcal;

    private float protein;

    private float sodium;

    private float fat;

    private float sugar;

}
