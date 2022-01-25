package com.example.honeybe_spring.service;

import com.example.honeybe_spring.domain.UserData;
import com.example.honeybe_spring.domain.dto.FeedContentDto;
import com.example.honeybe_spring.domain.repository.UserDataRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserDataService {
    private static final String TAG = "UserDataService.class";

    @Autowired
    private UserDataRepository userDataRepository;

    public void save(UserData userData) {
        log.info("TmiDataService save() call = {}", userData);
        userDataRepository.save(userData);
    }

    public List<UserData> userDataFindAll() {
        return userDataRepository.findAll();
    }

    public UserData userDataFindById(String u_id) {
        log.info(TAG + "userDataFindById = {}", u_id);
        List<UserData> all = userDataRepository.findAll();
        for (UserData userData : all) {
            if (userData.getU_id().equals(u_id)) {
                return userData;
            }
        }
        return null;
    }

    public UserData userDataUpdate(String u_id, ArrayList<String> pick_person) {
        List<UserData> all = userDataRepository.findAll();
        for (UserData userData : all) {
            if (userData.getU_id().equals(u_id)) {
                userData.setPick_person(pick_person);
                userDataRepository.save(userData);
                return userData;
            }
        }
        return null;
    }
}
