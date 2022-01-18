package com.example.honeybe_spring.domain.repository;

import com.example.honeybe_spring.domain.TmiData;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TmiDataRepository extends MongoRepository<TmiData, String> {

}
