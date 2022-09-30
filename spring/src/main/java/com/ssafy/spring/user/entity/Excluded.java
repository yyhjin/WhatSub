package com.ssafy.spring.user.entity;

import com.ssafy.spring.comb.entity.Ingredient;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class Excluded {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int excludedId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "ingredient_id")
    private Ingredient ingredient;

}
