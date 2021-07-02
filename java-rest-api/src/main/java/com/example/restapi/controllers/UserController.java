package com.example.restapi.controllers;

import com.example.restapi.models.User;
import com.example.restapi.repositories.CustomRepository;
import com.example.restapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private  final UserRepository userRepository;
    private final CustomRepository customRepository;

    @Autowired
    public UserController(UserRepository userRepository, CustomRepository customRepository){
        this.userRepository=userRepository;
        this.customRepository = customRepository;
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User getUserByUserId(@PathVariable String id){
        return userRepository.findByUser_id(id)
                .orElseThrow(()->new RuntimeException(
                        String.format("Cannot find user by User ID: %s",id)
                ));
    }

    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody User user){

        userRepository.insert(user);
        System.out.println("Successfully added User under User ID: "+user.getUser_id());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/update/")
    public ResponseEntity updateUser(@RequestBody User user){
        User savedUser = userRepository.findByUser_id(user.getUser_id())
                .orElseThrow(()-> new RuntimeException(
                        String.format("Cannot find user by User ID: %s",user.getUser_id())
        ));
        savedUser.setName(user.getName());
        savedUser.setEmail(user.getEmail());
        savedUser.setMobile_no(user.getMobile_no());

        customRepository.updateUser(user);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable String id){
        User user = userRepository.findByUser_id(id)
                .orElseThrow(()->new RuntimeException(
                        String.format("Cannot find user by User ID: %s",id)
                ));
        userRepository.deleteUserByUser_id(id);
        System.out.println("Successfully deleted User under User ID: "+id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
