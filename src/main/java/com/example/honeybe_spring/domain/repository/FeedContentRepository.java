package com.example.honeybe_spring.domain.repository;

import com.example.honeybe_spring.domain.FeedContent;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FeedContentRepository extends MongoRepository<FeedContent, String> {

}

