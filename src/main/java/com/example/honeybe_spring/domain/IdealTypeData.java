package com.example.honeybe_spring.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("idealTypeData")
public class IdealTypeData {
    Integer attractiveness;
    Integer sincerity;
    Integer intelligence;
    Integer fun;
    Integer ambition;
    Integer shared_interest;

    @Builder
    public IdealTypeData(Integer attractiveness, Integer sincerity,
                         Integer intelligence, Integer fun,
                         Integer ambition, Integer shared_interest) {
        this.attractiveness = attractiveness;
        this.sincerity = sincerity;
        this.intelligence = intelligence;
        this.fun = fun;
        this.ambition = ambition;
        this.shared_interest = shared_interest;
    }
}
