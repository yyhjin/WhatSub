//package com.ssafy.spring.comb.entity;
//
//import lombok.*;
//
//import javax.persistence.*;
//
//@Entity
//@Getter
//@Setter
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
//public class Composition {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int compositionId;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "combination_id")
//    private Combination combination;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "ingredient_id")
//    private Ingredient ingredient;
//}
