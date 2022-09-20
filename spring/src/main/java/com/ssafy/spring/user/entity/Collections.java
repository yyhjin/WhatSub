package com.ssafy.spring.user.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class Collections {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int collectionId;

    @ManyToOne
    @JoinColumn(name="user_id")
    private Users user;

    private String menuName;

    private int rank;

    private Date rankDate;
}
