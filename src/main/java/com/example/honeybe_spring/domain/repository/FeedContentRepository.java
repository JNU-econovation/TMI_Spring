package com.example.honeybe_spring.domain.repository;

import com.example.honeybe_spring.domain.FeedContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

public interface FeedContentRepository extends MongoRepository<FeedContent, String> {

}

