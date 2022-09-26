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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ingredientId;

    @NotBlank
    private String category;

    @NotBlank
    private String name;

    @NotBlank
    private String imgUrl;

    private int kcal;

    private float protein;

    private float sodium;

    private float fat;

    private float sugar;

    private String allergies;

    @Column(nullable = true)
    private int price;

    @OneToMany(mappedBy = "ingredient")
    private List<Composition> compositions = new ArrayList<>();
}
