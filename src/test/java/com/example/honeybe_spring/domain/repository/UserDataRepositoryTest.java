package com.example.honeybe_spring.domain.repository;

import com.example.honeybe_spring.domain.IdealTypeData;
import com.example.honeybe_spring.domain.InterestData;
import com.example.honeybe_spring.domain.UserData;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class UserDataRepositoryTest {

    @Autowired
    private UserDataRepository userDataRepository;

    @Test
    void save() {
        ArrayList<String> interest = new ArrayList<>();
        interest.add("흥미1");
        interest.add("흥미2");
        interest.add("흥미3");
        ArrayList<String> personality = new ArrayList<>();
        personality.add("성격1");
        personality.add("성격2");
        personality.add("성격3");
        personality.add("성격4");
        personality.add("성격5");
        personality.add("성격6");
        personality.add("성격7");
        ArrayList<String> pick_person = new ArrayList<>();
        pick_person.add("userId1");
        pick_person.add("userId2");
        pick_person.add("userId3");
        ArrayList<String> user_image = new ArrayList<>();
        user_image.add("https://www.notion.so/image/https%3A%2F%2Fs3-us-west-2.amazonaws.com%2Fsecure.notion-static.com%2Fb1de233c-25f8-453c-b3aa-624240a3b1aa%2Fimg_maenji.png?table=block&id=5e682d65-370b-4ae1-8add-a486523b5a65&spaceId=2eafe725-bbf7-46f5-9518-1060f10539d1&width=1960&userId=fb8eac07-3b56-4dc7-bc0c-074376ef6a85&cache=v2");
        user_image.add("image2");
        user_image.add("image3");

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

        int a=0;



        //when
        for (int i = 0; i < 550; i++) {
            UserData userData = UserData.builder()
                    .interestData(interestData).idealTypeData(idealTypeData)
                    .age(20).app_join("fun").department("산업공학과").dringking("drink")
                    .gender("man").height(162).interest(interest)
                    .introduce("나랑 포켓몬 잡으러 갈 사람").location(5).mbti("ENFJ")
                    .nickname("maenji").password("passwd").personality(personality)
                    .pick_person(pick_person).religion("무교")
                    .smoking("흡연").studentNumber("164761").u_id(String.valueOf(a))
                    .user_image(user_image).build();

            userDataRepository.save(userData);
            a++;
        }
        List<UserData> all = userDataRepository.findAll();
        //then
        Assertions.assertThat(all.get(0).getInterestData().getHiking()).isEqualTo(3);
    }

}