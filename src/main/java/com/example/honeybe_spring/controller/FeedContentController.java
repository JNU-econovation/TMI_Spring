package com.example.honeybe_spring.controller;

import com.example.honeybe_spring.domain.dto.FeedContentDto;
import com.example.honeybe_spring.service.FeedContentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class FeedContentController {

    @Autowired
    private FeedContentService feedContentService;

//    @GetMapping("users")
//    public List<FeedContentDto> findAll() {
//        List<FeedContentDto> all = feedContentService.findAll();
//        return all;
//    }

    @GetMapping("users/{userId}")
    public FeedContentDto findById(@PathVariable String userId) {
        FeedContentDto feedContentDto = feedContentService.findById(userId);
        return feedContentDto;
    }

//    @PostMapping("users")
//    public FeedContentDto save(@RequestBody FeedContentDto feedContentDto) {
//        log.info("PostMapping test-url called");
//        feedContentService.save(feedContentDto);
//
//        return feedContentDto;
//    }
}
