package com.ssafy.spring.user.entity;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

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

    @NotBlank
    private int combinationPostId;

    @NotBlank
    @ColumnDefault("true")
    private boolean state;
}
