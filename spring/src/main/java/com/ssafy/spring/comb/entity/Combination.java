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

    @NotBlank
    private String imgUrl;
}
