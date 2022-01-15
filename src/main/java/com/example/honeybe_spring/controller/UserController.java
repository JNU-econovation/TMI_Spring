package com.example.honeybe_spring.controller;

import com.example.honeybe_spring.domain.User;
import com.example.honeybe_spring.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;
    // Test
    @RequestMapping("/hello")
    public String Hello(){
        return "hello";
    }

    @PostMapping("/user/register")
    public User register(@RequestBody User user){
        // log.info("register User");
        userService.save(user);

        return user;
    }
}
