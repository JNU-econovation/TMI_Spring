package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication(scanBasePackages = {"com.example.honeybe_spring.jwt"})
@SpringBootApplication
public class HoneybeSpringApplication {
    public static void main(String[] args) {
        SpringApplication.run(HoneybeSpringApplication.class, args);
    }
}
