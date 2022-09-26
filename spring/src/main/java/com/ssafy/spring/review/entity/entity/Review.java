package com.ssafy.spring.review.entity.entity;

import com.ssafy.spring.comb.entity.CombinationPost;
import com.ssafy.spring.user.entity.User;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reviewId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="combination_post_id")
    private CombinationPost combinationPost;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;

    @NotBlank
    private String content;

    @NotNull //NotBlank는 String만 받을 수 있음
    private int score;

    @CreationTimestamp
    private Timestamp createdAt;

}
