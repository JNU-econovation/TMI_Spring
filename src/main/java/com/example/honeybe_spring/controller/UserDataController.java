package com.example.honeybe_spring.controller;

import com.example.honeybe_spring.domain.UserData;
import com.example.honeybe_spring.domain.dto.FeedContentDto;
import com.example.honeybe_spring.service.UserDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class UserDataController {
    private static final String TAG = "UserDataController.class";
    @Autowired
    private UserDataService userDataService;

    @PostMapping("users")
    public void save(@RequestBody UserData userData) {
        log.info("TmiDataController save() call = {}", userData);
        userDataService.save(userData);
    }

    @GetMapping("users")
    public List<UserData> findAll() {
        List<UserData> all = userDataService.userDataFindAll();
        return all;
    }

    @GetMapping("users/{u_id}/feedContent")
    public FeedContentDto feedContentFindById(@PathVariable String u_id) {
        return userDataService.feedContentFindById(u_id);
    }

    @GetMapping("users/{u_id}/datas")
    public UserData userDataFindById(@PathVariable String u_id) {
        log.info(TAG + "userDataFindById = {}", u_id);
        UserData userData = userDataService.userDataFindById(u_id);
        log.info("userData = {}", userData);
        return userData;
    }

    @PatchMapping("users/{u_id}/datas")
    public UserData userDataUpdate(@PathVariable String u_id, @RequestBody ArrayList<String> pick_person) {
        UserData userData = userDataService.userDataUpdate(u_id, pick_person);
        log.info("userDataUpdate userData = {}", userData);
        return userData;
    }
}
