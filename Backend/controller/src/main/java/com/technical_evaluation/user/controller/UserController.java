package com.technical_evaluation.user.controller;

import com.technical_evaluation.user.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.technical_evaluation.services.expense.services.UserService;

import java.util.List;


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
