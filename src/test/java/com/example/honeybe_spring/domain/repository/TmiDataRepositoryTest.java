package com.example.honeybe_spring.domain.repository;

import com.example.honeybe_spring.domain.IdealTypeData;
import com.example.honeybe_spring.domain.InterestData;
import com.example.honeybe_spring.domain.TmiData;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.awt.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TmiDataRepositoryTest {

    @Autowired
    private TmiDataRepository tmiDataRepository;

    @Test
    void save() {
        //given
        InterestData interestData = InterestData.builder()
                .art(0).concerts(0).dining(0).exercise(2)
                .hiking(3).movies(10).museums(5).reading(7)
                .music(8).shopping(12).sports(2).theater(7).tv(3)
                .build();

        IdealTypeData idealTypeData = IdealTypeData.builder()
                .ambition(10).fun(4).attractiveness(3).intelligence(5)
                .shared_interest(5).sincerity(3)
                .build();

        TmiData tmiData = TmiData.builder()
                .interestData(interestData).idealTypeData(idealTypeData)
                .age(20).app_join("fun").department("ie").dringking("drink")
                .gender("man").height(180).interest(new String[]{"1", "2", "3"})
                .introduce("자기소개").location(new Point(30, 30)).mbti("ISTP")
                .nickname("queque").password("passwd").personality(new String[]{"test1", "test2"})
                .pick_person(new String[]{"aPerson", "bPerson"}).religion("christ")
                .smoking("smoking").studentNumber("164761").u_id("userId")
                .user_image(new String[]{"img1", "img2", "img3"}).build();

        //when
        tmiDataRepository.save(tmiData);
        List<TmiData> all = tmiDataRepository.findAll();
        //then
        Assertions.assertThat(all.get(0).getInterestData().getHiking()).isEqualTo(3);
    }

}