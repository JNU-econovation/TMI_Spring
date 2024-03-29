package com.example.honeybe_spring.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.awt.*;
import java.util.ArrayList;

@Data
@Document("userData")
public class UserData {
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
    Integer location;
    String smoking;
    String dringking;
    Integer height;
    ArrayList<String> user_image;
    InterestData interestData;      // 관심사
    ArrayList<String> interest;
    ArrayList<String> personality;
    String introduce;
    IdealTypeData idealTypeData;    // 이상형
    String app_join;                // 어플 가입 목적
    ArrayList<String> pick_person;           // string[]

    @Builder
    public UserData(String u_id, String password, String nickname,
                    Integer age, String gender, String studentNumber,
                    String department, String mbti, String religion,
                    Integer location, String smoking, String dringking,
                    Integer height, ArrayList<String> user_image, InterestData interestData,
                    ArrayList<String> interest, ArrayList<String> personality, String introduce,
                    IdealTypeData idealTypeData, String app_join, ArrayList<String> pick_person) {

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
