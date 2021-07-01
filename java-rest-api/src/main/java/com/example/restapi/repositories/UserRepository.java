package com.example.restapi.repositories;

import com.example.restapi.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    @Query("{'user_id':?0}")
    Optional<User> findByUser_id(String user_id);
}
