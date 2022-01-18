package com.example.honeybe_spring.service;

import com.example.honeybe_spring.domain.FeedContent;
import com.example.honeybe_spring.domain.TmiData;
import com.example.honeybe_spring.domain.dto.LikeUserDto;
import com.example.honeybe_spring.domain.repository.FeedContentRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
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

    public void save(FeedContent feedContent){
        log.info("FeedContentService feedContent = {}", feedContent.toString());
        feedContentRepository.save(feedContent);

    }


    public List<FeedContent> findAll() {
        List<FeedContent> all = feedContentRepository.findAll();
        return all;
    }

    public FeedContent findById(String id) {
        Optional<FeedContent> optionalFeedContent = feedContentRepository.findById(id);

        if(optionalFeedContent.isPresent()) {
            FeedContent feedContent = optionalFeedContent.get();
            return feedContent;
        }

        return null;
    }

    public LikeUserDto getLikeUser(String id) {
        Optional<FeedContent> optionalFeedContent = feedContentRepository.findById(id);

        if (optionalFeedContent.isPresent()) {
            FeedContent feedContent = optionalFeedContent.get();
            LikeUserDto likeUserDto = LikeUserDto.builder()
                    .profile(feedContent.getProfile())
                    .name(feedContent.getName())
                    .age(feedContent.getAge())
                    .build();
            return likeUserDto;
        }
        return null;
    }


}
