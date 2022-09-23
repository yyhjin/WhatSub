package com.ssafy.spring.comb.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Combination {

    @Id
    private String combinationId;

    @OneToMany(mappedBy = "combination")
    private List<Composition> compositions = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "menu_id")
    private Menu menu;

    @NotBlank
    private int kcal;

    private float protein;

    private float sodium;

    private float fat;

    private float sugar;

    private String allergies;

    private int price;

    private String imgUrl;
}
