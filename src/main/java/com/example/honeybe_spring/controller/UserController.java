package com.example.honeybe_spring.controller;

import com.example.honeybe_spring.domain.User;
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

    @GetMapping("/user/info")
    public UserDetails requestInfo(@RequestParam("uid") String uid){
        // log.info("register User");
        return customUserDetailsService.loadUserByUsername(uid);
    }



    @PostMapping("/user/login")
    public String login(@RequestBody User user){
        String uid = user.getUid();
        UserDetails member = customUserDetailsService.loadUserByUsername(uid);

        /*
        User member = userRepository.findByuid(user.get("uid"))
                .orElseThrow(()->new IllegalArgumentException("가입되지 않은 id입니다."));

         */

        if (!passwordEncoder.matches(user.getPassword(), member.getPassword())){
            throw new IllegalArgumentException("잘못된 비밀번호입니다.");
        }

        return jwtAuthenticationProvider.createToken(member.getUsername());

        // String token = jwtAuthenticationProvider.createToken(member.getUsername(), member.getRoles());
        /*
        String token = jwtAuthenticationProvider.createToken(member.getUsername());
        response.setHeader("X-AUTH-TOKEN", token);

        Cookie cookie = new Cookie("X-AUTH-TOKEN", token);
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        cookie.setSecure(true);
        response.addCookie(cookie);

        return token;

         */
    }

    /*
    @PostMapping("/user/login")
    public String login(@RequestBody User user, HttpServletResponse response){
        User member = userRepository.findById(user.getId())
                .orElseThrow(()->new IllegalArgumentException("가입되지 않은 id입니다."));
        if (!passwordEncoder.matches(user.getPassword(), member.getPassword())){
            throw new IllegalArgumentException("잘못된 비밀번호입니다.");
        }

        String token = jwtAuthenticationProvider.createToken(member.getUsername(), member.getRoles());
        response.setHeader("X-AUTH-TOKEN", token);

        Cookie cookie = new Cookie("X-AUTH-TOKEN", token);
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        cookie.setSecure(true);
        response.addCookie(cookie);

        return token;
    }

     */
}
