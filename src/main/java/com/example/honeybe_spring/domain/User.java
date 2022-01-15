package com.example.honeybe_spring.domain;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Getter
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long _id;

    private String id;
    private String password;
    private String nickname;

    @Builder
    public User(String id, String password, String nickname){
        this.id = id;
        this.password = password;
        this.nickname = nickname;
    }
}
