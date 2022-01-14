package com.example.honeybe_spring.service;

import com.example.honeybe_spring.domain.FeedContent;
import com.example.honeybe_spring.domain.repository.FeedContentRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class FeedContentService {
    @Autowired
    private FeedContentRepository feedContentRepository;

    public void save(FeedContent feedContent){
        log.info("FeedContentService feedContent = {}", feedContent.toString());

        feedContentRepository.save(feedContent);
    }


    public List<FeedContent> findAll() {
        List<FeedContent> all = feedContentRepository.findAll();
        return all;
    }
}
