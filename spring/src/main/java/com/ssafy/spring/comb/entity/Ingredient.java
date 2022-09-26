package com.ssafy.spring.comb.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ingredient {

    @Id
    private String ingredientId;

    @NotBlank
    private String category;

    @NotBlank
    private String name;

    @NotBlank
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
