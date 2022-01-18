package com.example.honeybe_spring.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.awt.*;

@Data
@Document("tmiData")
public class TmiData {
    @Id
    String _id;
    String u_id;
    String password;
    String nickname;
    Integer age;
    String gender;
    String studentNumber;
    String department;
    String mbti;
    String religion;
    Point location;
    String smoking;
    String dringking;
    Integer height;
    String[] user_image;

    InterestData interestData;      // 관심사

    String[] interest;
    String[] personality;
    String introduce;

    IdealTypeData idealTypeData;    // 이상형

    String app_join;                // 어플 가입 목적
    String[] pick_person;           // string[]

    @Builder
    public TmiData(String u_id, String password, String nickname,
                   Integer age, String gender, String studentNumber,
                   String department, String mbti, String religion,
                   Point location, String smoking, String dringking,
                   Integer height, String[] user_image, InterestData interestData,
                   String[] interest, String[] personality, String introduce,
                   IdealTypeData idealTypeData, String app_join, String[] pick_person) {

        this.u_id = u_id;
        this.password = password;
        this.nickname = nickname;
        this.age = age;
        this.gender = gender;
        this.studentNumber = studentNumber;
        this.department = department;
        this.mbti = mbti;
        this.religion = religion;
        this.location = location;
        this.smoking = smoking;
        this.dringking = dringking;
        this.height = height;
        this.user_image = user_image;
        this.interestData = interestData;
        this.interest = interest;
        this.personality = personality;
        this.introduce = introduce;
        this.idealTypeData = idealTypeData;
        this.app_join = app_join;
        this.pick_person = pick_person;
    }
}
