package com.example.honeybe_spring.domain;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Document(collation = "user")
@Getter
// @NoArgsConstructor
// @Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private ObjectId _id;

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
