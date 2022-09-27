package com.ssafy.spring.comb.entity;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;


@Entity
@Getter
@Setter
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

    private int soft;

    private int salty;

    private int chewy;

    private int sour;

    private int sweet;

    private int nutty;

    private int spicy;

    private int bland;
}
