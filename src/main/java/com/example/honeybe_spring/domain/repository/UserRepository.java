package com.example.honeybe_spring.domain.repository;
import com.example.honeybe_spring.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    // Optional<User> findByU_id(String u_id) ;

    Optional<User> findByuid(String username);
}
