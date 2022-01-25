package com.example.honeybe_spring.domain.repository;

import com.example.honeybe_spring.domain.UserData;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserDataRepository extends MongoRepository<UserData, String> {

}
