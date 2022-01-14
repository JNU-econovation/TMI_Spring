package com.example.honeybe_spring.controller;

import com.example.honeybe_spring.domain.FeedContent;
import com.example.honeybe_spring.service.FeedContentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class FeedContentController {

    @Autowired
    private FeedContentService feedContentService;

//    @GetMapping("test-url/{id}")
//    public String testMapping(@PathVariable String id) {
//        return "ok";
//    }

    @GetMapping("test-url/{id}")
    public List<FeedContent> findAll(@PathVariable String id) {
        log.info("id : {}", id);
        List<FeedContent> all = feedContentService.findAll();
        return all;
    }

    @PostMapping("test-url")
    public FeedContent save(@RequestBody FeedContent feedContent) {
        log.info("PostMapping test-url called");
        feedContentService.save(feedContent);

        return feedContent;
    }
}
