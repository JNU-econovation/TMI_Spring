package com.example.honeybe_spring.controller;

import com.example.honeybe_spring.domain.TmiData;
import com.example.honeybe_spring.service.TmiDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class TmiDataController {

    @Autowired
    private TmiDataService tmiDataService;

    @PostMapping("test")
    public void save(@RequestBody TmiData tmiData) {
        log.info("TmiDataController save() call = {}", tmiData);
        tmiDataService.save(tmiData);
    }

    @GetMapping("test")
    public List<TmiData> findAll() {
        List<TmiData> all = tmiDataService.findAll();
        return all;
    }
}
