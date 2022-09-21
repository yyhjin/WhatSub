package com.ssafy.spring.comb.entity;

import com.fasterxml.jackson.annotation.JsonRawValue;
import com.ssafy.spring.review.entity.entity.Review;
import lombok.Getter;
import lombok.Setter;
import springfox.documentation.spring.web.json.Json;

import javax.persistence.*;
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

    private String combName;

    private String content;

    private int likesCnt;

    private Date createdAt;

    @JsonRawValue
    private String statistics;

    @OneToMany(mappedBy = "combinationPost")
    private List<Review> reviews = new ArrayList<>();
}
