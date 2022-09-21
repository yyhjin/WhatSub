package com.ssafy.spring.user.entity;

import lombok.*;

import javax.persistence.*;
import static javax.persistence.FetchType.LAZY;
import java.util.Date;

import static javax.persistence.FetchType.LAZY;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class Collection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int collectionId;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name="user_id")
    private User user;

    private String menuName;

    private int ranking;

    private Date rankDate;
}
