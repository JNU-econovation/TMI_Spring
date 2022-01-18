package com.example.honeybe_spring.domain;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Document("feedContent")
public class FeedContent {
    @Id
    private String id;
    private String profile;
    private String name;
    private int age;
    private int score;
    private String[] personalities;
    private String introduce;
    private String[] userId;

    public FeedContent() {
    }

    @Builder
    public FeedContent(String profile, String name, int age, int score, String[] personalities, String introduce, String[] userId) {
        this.profile = profile;
        this.name = name;
        this.age = age;
        this.score = score;
        this.personalities = personalities;
        this.introduce = introduce;
        this.userId = userId;
    }
}
