package com.ssafy.spring.review.entity.entity;

import com.ssafy.spring.user.entity.User;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
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

//    @ManyToOne
//    @JoinColumn(name="combination_post_id")
//    private CombinationPost combinationPost;
//
//    @ManyToOne
//    @JoinColumn(name="user_id")
//    private Users user;

    @NotBlank
    @Lob
    private String content;

    @NotBlank
    private int score;

    @CreationTimestamp
    private Timestamp createdAt;

}
