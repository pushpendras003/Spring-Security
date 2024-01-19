package com.example.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.User;
import com.example.service.UserService;

@Component
@RestController
@RequestMapping("/start")
public class HomeCntroller {
	
	@Autowired
	UserService service;
	
	public HomeCntroller() {
		super();
		// TODO Auto-generated constructor stub
	}

	@PostMapping("/user")
	public void addUser(@RequestBody User user) {
		
		service.addUser(user);
	}
	@GetMapping("/user/{id}")
	public User getUser(@PathVariable("id") int id) {
		return service.getUser(id);
	}
	
	@GetMapping("/user")
	
	public ArrayList<User> getAll(){
		System.out.print("inside");
		
		return service.getAll();
	}

}
