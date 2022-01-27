package com.example.honeybe_spring.controller;

import com.example.honeybe_spring.domain.User;
import com.example.honeybe_spring.domain.dto.Login;
import com.example.honeybe_spring.domain.repository.UserRepository;
import com.example.honeybe_spring.config.JwtAuthenticationProvider;
import com.example.honeybe_spring.service.CustomUserDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@RestController
public class UserController {


    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    /*
    @Autowired
    private CustomUserDetailsService customUserDetailsService;
     */

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtAuthenticationProvider jwtAuthenticationProvider;

    // Test
    @RequestMapping("/hello")
    public String Hello(){
        return "hello";
    }

    @PostMapping("/user/register")
    public User register(@RequestBody User user){
        // log.info("register User");
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        customUserDetailsService.save(user);

        return user;
    }


    @PostMapping("/user/login")
    public String login(@RequestBody User user){
        String uid = user.getUid();
        Login member = customUserDetailsService.loadUserByUsername(uid);

        if (!passwordEncoder.matches(user.getPassword(), member.getPassword())){
            throw new IllegalArgumentException("잘못된 비밀번호입니다.");
        }

        return jwtAuthenticationProvider.createToken(member.getPassword());
    }

}
