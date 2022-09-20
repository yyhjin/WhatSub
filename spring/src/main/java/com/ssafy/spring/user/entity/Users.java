package com.ssafy.spring.user.entity;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    private String authId;

    @NotBlank
    private String email;

    @NotBlank
    private String gender;

    @NotBlank
    private int birthYear;

    @NotBlank
    @Column(unique = true)
    private String userName;

    private String profileImg;

    private String subti;

    @NotBlank
    @ColumnDefault("false")
    private boolean isDiet;

    private String refreshToken;

}
