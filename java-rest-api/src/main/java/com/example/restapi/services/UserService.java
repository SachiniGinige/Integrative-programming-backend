package com.example.restapi.services;

import com.example.restapi.models.User;
import com.example.restapi.repositories.CustomRepository;
import com.example.restapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final CustomRepository customRepository;


    @Autowired
    public UserService(UserRepository userRepository, CustomRepository customRepository){
        this.userRepository=userRepository;
        this.customRepository = customRepository;
    }

    public  List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserByUserId(String id){
        return userRepository.findByUser_id(id)
                .orElseThrow(()->new RuntimeException(
                        String.format("Cannot find user by User ID: %s",id)
                ));
    }

    public void addUser(User user){
        userRepository.insert(user);
        System.out.println("Successfully added User under User ID: "+user.getUser_id());
    }

    public void updateUser(User user) {
        User savedUser = userRepository.findByUser_id(user.getUser_id())
                .orElseThrow(() -> new RuntimeException(
                        String.format("Cannot find user by User ID: %s", user.getUser_id())
                ));
        savedUser.setName(user.getName());
        savedUser.setEmail(user.getEmail());
        savedUser.setMobile_no(user.getMobile_no());

        customRepository.updateUser(user);
    }
    public void deleteUser(String id){
        userRepository.findByUser_id(id)
                .orElseThrow(()->new RuntimeException(
                        String.format("Cannot find user by User ID: %s",id)
                ));
        userRepository.deleteUserByUser_id(id);
        System.out.println("Successfully deleted User under User ID: "+id);
    }
}
