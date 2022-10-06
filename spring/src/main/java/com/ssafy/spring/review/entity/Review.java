package com.ssafy.spring.review.entity;

import com.ssafy.spring.comb.entity.CombinationPost;
import com.ssafy.spring.review.dto.ReviewResponse;
import com.ssafy.spring.user.entity.User;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;


@ToString
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

    @Column(nullable = false)
    private String content;

    private int score;

    @CreationTimestamp
    private Timestamp createdAt;

    public static ReviewResponse.ResponseDto EntityToDto(Review review) {
        return ReviewResponse.ResponseDto.builder()
                .reviewId(review.getReviewId())
                .content(review.getContent())
                .createdAt(review.getCreatedAt())
                .score(review.getScore())
                .combinationPostId(review.getCombinationPost().getCombinationPostId())
                .userId(review.getUser().getUserId())
                .profileImg(review.getUser().getProfileImg())
                .build();
    }
}
