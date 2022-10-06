package com.ssafy.spring.ranking.entity;

import com.fasterxml.jackson.annotation.JsonRawValue;
import com.ssafy.spring.comb.entity.Menu;
import lombok.Builder;

import javax.persistence.*;
import java.util.Date;

@Builder
@Entity
public class Ranking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rankingId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="menu_id")
    private Menu menu;

    @Column(columnDefinition = "json")
    @JsonRawValue
    private String data;

    private Date rankDate;


    //    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name="user_id")
//    private User user;

//    private int cnt;
//    private int no;
}
