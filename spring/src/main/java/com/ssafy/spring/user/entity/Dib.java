package com.ssafy.spring.user.entity;

import com.ssafy.spring.comb.entity.CombinationPost;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class Dib {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int dibId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

//    @NotNull
//    private int combinationPostId;

    @ManyToOne
    @JoinColumn(name = "combination_post_id")
    private CombinationPost combinationPost;

    @NotNull
    private boolean state = true;

    public void stateUpdate(boolean state) {
        this.state = state;
    }
}
