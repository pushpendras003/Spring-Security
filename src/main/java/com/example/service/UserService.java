package com.example.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.model.User;
import com.example.repo.UserRepositoryImpl;

import jakarta.annotation.PostConstruct;

@Service
public class UserService {
	
	
	UserRepositoryImpl userRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	public UserService(UserRepositoryImpl userRepo) {
		this.userRepo=userRepo;
	}
	@PostConstruct
    public void initializeUsers() {
        userRepo.save(new User("Ram", "1", passwordEncoder.encode("password"), "USER"));
        userRepo.save(new User("Sita", "2", passwordEncoder.encode("password1"), "ADMIN"));
    }

	
	public User addUser(User user) {
		
		userRepo.save(user);
		return user;
	}
	
	public User getUserByUsername(String username) {
		User u=userRepo.findByName(username);
		u.setPassword(passwordEncoder.encode(u.getPasswordl()));
		if(u==null) {
			throw new UsernameNotFoundException("User Not Found");
			
		}
		return u;
	}
	
	public Optional<User> getUserById(String id) {
		Optional<User> u=userRepo.findById(id);
		if(u==null) {
			throw new UsernameNotFoundException("User Not Found");
			
		}
		return u;
	}
	
	public Iterable<User> getAll(){
		return userRepo.findAll();
	}
	
	
	
	

}
