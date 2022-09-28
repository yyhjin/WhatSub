package com.ssafy.spring.user.entity;

import com.ssafy.spring.comb.entity.CombinationPost;
import com.ssafy.spring.review.entity.Review;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    private String authId;

    @NotBlank
    private String email;

    @NotBlank
    private String gender;

    @NotBlank
    private int birthYear;

    @NotBlank
    @Column(unique = true)
    private String userName;

    private String profileImg;

    private String subti;

    @NotBlank
    @ColumnDefault("false")
    private boolean isDiet;

    private String refreshToken;

    @OneToMany(mappedBy = "user")
    private List<CombinationPost> combinationPosts = new ArrayList<>();
}
