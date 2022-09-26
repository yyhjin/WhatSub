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
    private String menuId;

    @NotBlank
    private String imgUrl;

    @NotBlank
    private String menuName;

    @NotBlank
    private String ingredients;

    @NotBlank
    private String menuDesc;

    private String allergies;

    private int price;

    private float kcal;

    private float protein;

    private float sodium;

    private float fat;

    private float sugar;

}
