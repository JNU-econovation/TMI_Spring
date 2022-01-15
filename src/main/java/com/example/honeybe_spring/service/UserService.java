package com.example.honeybe_spring.service;

import com.example.honeybe_spring.domain.User;
import com.example.honeybe_spring.domain.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void save(User user){
        userRepository.save(user);
    }
}

