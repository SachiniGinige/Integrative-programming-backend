package com.example.restapi.repositories;

import com.example.restapi.models.User;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomRepository {
    public long updateUser(User user);
}

