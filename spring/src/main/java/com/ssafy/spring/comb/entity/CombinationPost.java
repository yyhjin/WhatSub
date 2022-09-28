package com.ssafy.spring.comb.entity;

import com.fasterxml.jackson.annotation.JsonRawValue;
import com.ssafy.spring.review.entity.Review;
import com.ssafy.spring.user.entity.User;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class CombinationPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int combinationPostId;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "combination_id")
    private Combination combination;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;

    private String combName;

    private String content;

    private String imgUrl;

    @ColumnDefault("0")
    private int likesCnt;

    @CreationTimestamp
    private Timestamp createdAt;

    @Column(columnDefinition = "json")
    @JsonRawValue
    private String statistics;

    @OneToMany(mappedBy = "combinationPost")
    private List<Review> reviews = new ArrayList<>();
}
