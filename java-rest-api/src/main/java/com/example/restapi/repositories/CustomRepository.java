package com.example.restapi.repositories;

import com.example.restapi.models.User;

public interface CustomRepository {
    public void addUser(String user_id, String name, String email, String mobile_no);
    public long updateUser(String user_id, String name, String email, String mobile_no);
}

