package com.ssafy.spring.comb.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
@Getter
@Setter
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int menuId;

    @NotBlank
    private String imgUrl;

    @NotBlank
    private String menuName;

    private String menuDesc;

    private String allergies;

    @NotBlank
    private int price;

    private int weight;

    @NotBlank
    private int kcal;

    @NotBlank
    private float protein;

    @NotBlank
    private float sodium;

    @NotBlank
    private float fat;

    @NotBlank
    private float sugar;

    @NotBlank
    private int length;
}
