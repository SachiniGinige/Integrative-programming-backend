package com.example.restapi.repositories;

import com.example.restapi.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
//    User findUserByUser_id(String id);
}
