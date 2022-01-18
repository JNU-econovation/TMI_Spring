package com.example.honeybe_spring.domain.repository;

import com.example.honeybe_spring.domain.FeedContent;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class FeedContentRepositoryTest {
    @Autowired
    private FeedContentRepository feedContentRepository;

    @Test
    void test() {
        String[] personalities = {"활발함", "소심함", "적극적","asds","Ads","asdas","fadfs"};
        String[] userId = {"1", "2", "3"};

        //given
        FeedContent feedContent = FeedContent.builder()
                .profile("profile")
                .name("name")
                .age(20)
                .personalities(personalities)
                .introduce("introduce")
                .userId(userId)
                .build();

        //when
        feedContentRepository.save(feedContent);
        List<FeedContent> all = feedContentRepository.findAll();

        //then
        Assertions.assertThat(all.get(0).getName()).isEqualTo("name");
    }
}