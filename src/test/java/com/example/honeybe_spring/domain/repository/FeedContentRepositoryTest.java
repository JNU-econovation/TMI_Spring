package com.example.honeybe_spring.domain.repository;

import com.example.honeybe_spring.domain.dto.FeedContentDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class FeedContentRepositoryTest {
    @Autowired
    private FeedContentRepository feedContentRepository;

    @Test
    void saveTest() {
        //given
        FeedContentDto feedContentDto = FeedContentDto.builder()
                .user_image(new String[]{"image1", "image2", "image3"})
                .nickname("nickname")
                .age(20)
                .personality(new String[]{"p1", "p2", "p3", "p4", "p5", "p6", "p7"})
                .introduce("introduce")
                .build();

        //when
        FeedContentDto save = feedContentRepository.save(feedContentDto);
        List<FeedContentDto> all = feedContentRepository.findAll();

        //then
        Assertions.assertThat(all.get(0).getIntroduce()).isEqualTo("introduce");
    }
}