package com.example.honeybe_spring.controller;

import com.example.honeybe_spring.domain.FeedContent;
import com.example.honeybe_spring.domain.TmiData;
import com.example.honeybe_spring.domain.dto.LikeUserDto;
import com.example.honeybe_spring.service.FeedContentService;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
public class FeedContentController {

    @Autowired
    private FeedContentService feedContentService;

    @GetMapping("users")
    public List<FeedContent> findAll() {
        List<FeedContent> all = feedContentService.findAll();
        return all;
    }

    @GetMapping("users/{id}")
    public FeedContent findById(@PathVariable String id) {
        FeedContent feedContent = feedContentService.findById(id);
        return feedContent;
    }

    @PostMapping("users")
    public FeedContent save(@RequestBody FeedContent feedContent) {
        log.info("PostMapping test-url called");
        feedContentService.save(feedContent);

        return feedContent;
    }


    @GetMapping("users/{id}/like")
    public LikeUserDto getLikeUser(@PathVariable String id) {
        LikeUserDto likeUser = feedContentService.getLikeUser(id);
        return likeUser;
    }

    @PostMapping("users/{id}/like")
    public void postLikeUser(@PathVariable String id) {

    }
}
