package com.ssafy.spring.user.entity;

import com.ssafy.spring.comb.entity.CombinationPost;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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

    private String email;

    private String gender;

    private int birthYear;

    @Column(unique = true)
    private String userName;

    @ColumnDefault("https://whatsub.s3.ap-northeast-2.amazonaws.com/default/p0.png")
    private String profileImg;

    private String subti;

    @NotNull
    @ColumnDefault("false")
    private boolean isDiet;

    private String refreshToken;

    @OneToMany(mappedBy = "user")
    private List<CombinationPost> combinationPosts = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Collection> collections = new ArrayList<>();

}
