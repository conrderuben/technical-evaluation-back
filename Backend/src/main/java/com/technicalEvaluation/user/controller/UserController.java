package com.technicalEvaluation.user.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.technicalEvaluation.user.entities.User;
import com.technicalEvaluation.user.services.UserService;


@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/")
	public List<User> getAllUsers(){
		return userService.getAllUsers(1L);
	}
	
	@PostMapping("/")
	public User createUser(@RequestBody User user) {
		return userService.createUser(user);
		
	}
	
}
