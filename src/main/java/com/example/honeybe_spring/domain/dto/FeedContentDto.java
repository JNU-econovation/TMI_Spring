package com.example.honeybe_spring.domain.dto;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Document("feedContentDto")
public class FeedContentDto {
    
    private String[] user_image;
    private String nickname;
    private Integer age;
    private String[] personality;
    private String introduce;

    public FeedContentDto() {
    }

    @Builder
    public FeedContentDto(String[] user_image, String nickname, Integer age, String[] personality, String introduce) {
        this.user_image = user_image;
        this.nickname = nickname;
        this.age = age;
        this.personality = personality;
        this.introduce = introduce;
    }
}

