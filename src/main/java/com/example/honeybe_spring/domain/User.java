package com.example.honeybe_spring.domain;

import lombok.*;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Document("user")
@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class User implements UserDetails {
    @Id
    String id;

    @Column
    String uid;
    String password;
    String nickname;

    Integer age;
    String gender;
    String studentNumber;
    String department;
    String mbti;
    String religion;
    String location;
    String smoking;
    String drinking;
    Integer height;
    String[] user_image;

    InterestData interestData;
    String[] interest;
    String[] personality;
    String introduce;

    IdealTypeData idealTypeData;

    String app_join;
    String[] pick_person;

    private List<String> roles = new ArrayList<>();

    private PasswordEncoder passwordEncoder;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword(){
        return password;
    }


    /*
    @Override
    public String getUsername() {
        return id;
    }

     */

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Builder
    public User(String uid, String password, String nickname, Integer age, String gender, String studentNumber, String department, String mbti, String religion,
                String location, String smoking, String drinking, Integer height, String[] user_image, InterestData interestData, String[] interest,
                String[] personality, String introduce, IdealTypeData idealTypeData, String app_join, String[] pick_person){
        this.uid = uid;
        // this.password = passwordEncoder.encode(password);
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
        this.drinking = drinking;
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

    @Override
    public String getUsername() {
        return uid;
    }

    public String getuid(String uid) {
        return uid;
    }

    public String get(String uid) {
        return uid;
    }
}
