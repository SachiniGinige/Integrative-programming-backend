package com.example.restapi.controllers;

import com.example.restapi.models.User;
import com.example.restapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private  final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
//    @GetMapping("/users/{id}")
//    public User getUserById(@PathVariable String id){
//        return userRepository.findUserByUser_id(id);
//    }
    @PostMapping("users/add")
    public User addUser(@RequestBody User user){
        return userRepository.save(user);
    }
//    @PutMapping("users/update/{id}")
//    public User updateUser(@PathVariable String id, @RequestBody User user){
//        return userRepository.save(user);
//    }

//    @DeleteMapping("users/delete/{id}")
//    public void deleteUser(@PathVariable String id){
//        userRepository.deleteById(id);
//    }

}
