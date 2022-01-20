package com.example.honeybe_spring.service;

import com.example.honeybe_spring.domain.dto.FeedContentDto;
import com.example.honeybe_spring.domain.repository.FeedContentRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class FeedContentService {

    @Autowired
    private FeedContentRepository feedContentRepository;

    public void save(FeedContentDto feedContentDto){
        log.info("FeedContentService feedContent = {}", feedContentDto.toString());
        feedContentRepository.save(feedContentDto);
    }

    public List<FeedContentDto> findAll() {
        List<FeedContentDto> all = feedContentRepository.findAll();
        return all;
    }

    public FeedContentDto findById(String id) {
        Optional<FeedContentDto> optionalFeedContent = feedContentRepository.findById(id);

        if(optionalFeedContent.isPresent()) {
            FeedContentDto feedContentDto = optionalFeedContent.get();
            return feedContentDto;
        }

        return null;
    }

}
