package com.example.honeybe_spring.domain.dto;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Document("feedContentDto")
public class FeedContentDto {
    
    private ArrayList<String> user_image;
    private String nickname;
    private Integer age;
    private String department;
    private Integer location;
    private String mbti;
    private ArrayList<String> personality;
    private String introduce;
    private String smoke;
    private String drink;
    private Integer height;

    @Builder
    public FeedContentDto(ArrayList<String> user_image, String nickname, Integer age, String department, Integer location, String mbti, ArrayList<String> personality, String introduce, String smoke, String drink, Integer height) {
        this.user_image = user_image;
        this.nickname = nickname;
        this.age = age;
        this.department = department;
        this.location = location;
        this.mbti = mbti;
        this.personality = personality;
        this.introduce = introduce;
        this.smoke = smoke;
        this.drink = drink;
        this.height = height;
    }
}

