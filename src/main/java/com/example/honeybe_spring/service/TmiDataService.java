package com.example.honeybe_spring.service;

import com.example.honeybe_spring.domain.TmiData;
import com.example.honeybe_spring.domain.repository.TmiDataRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class TmiDataService {
    @Autowired
    private TmiDataRepository tmiDataRepository;

    public void save(TmiData tmiData) {
        log.info("TmiDataService save() calle = {}", tmiData);
        tmiDataRepository.save(tmiData);
    }

    public List<TmiData> findAll() {
        return tmiDataRepository.findAll();
    }
}
