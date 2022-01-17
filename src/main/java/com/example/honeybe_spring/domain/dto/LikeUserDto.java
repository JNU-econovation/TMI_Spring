package com.example.honeybe_spring.domain.dto;


import lombok.Builder;
import lombok.Data;

@Data
public class LikeUserDto {
    private String profile;
    private String name;
    private int age;

    @Builder
    public LikeUserDto(String profile, String name, int age) {
        this.profile = profile;
        this.name = name;
        this.age = age;
    }
}
