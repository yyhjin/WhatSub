package com.ssafy.spring.recommend.entity;

import com.ssafy.spring.comb.entity.Menu;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Getter
@Setter
public class TodaySurvey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int todaySurveyId;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_id")
    private Menu menu;

    @NotBlank
    private String response;
}
