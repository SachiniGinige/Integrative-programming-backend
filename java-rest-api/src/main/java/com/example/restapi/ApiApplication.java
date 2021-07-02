package com.example.restapi;

import com.example.restapi.models.User;
import com.example.restapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing
public class ApiApplication implements CommandLineRunner{

	private final UserRepository userRepository;

	@Autowired
	public ApiApplication(UserRepository userRepository){
		this.userRepository=userRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("Application Running...");

//		printAllUsers();
	}

//	private void printAllUsers() {
//		if(userRepository.findAll().isEmpty()){
//			addSampleUsers();
//		}
//		for (User user: userRepository.findAll()){
//			System.out.println(user);
//		}
//	}
//
//	private void addSampleUsers() {
//		userRepository.save(new User("user1","sampleuser1","sampleuser1@gmail.com","0753397120"));
//		userRepository.save(new User("user2","sampleuser2","sampleuser2@gmail.com","0753397120"));
//		System.out.println("Sample users added!");
//	}
}
