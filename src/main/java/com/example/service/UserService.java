package com.example.service;

import java.util.ArrayList;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.model.User;

@Component
public class UserService {
	
	ArrayList<User> users=new ArrayList<User>();
	
	public UserService() {
		this.users.add(new User("Ram",1,"ram@email.com"));
		this.users.add(new User("Shayam",2,"shayam@email.com"));
	}
	
	public User getUser(int id) {
		return this.users.stream().filter((User)->User.getId()==id).findFirst().orElse(null);
	}
	
	public ArrayList<User> getAll(){
		return this.users;
	}
	
	public void addUser(User user) {
		this.users.add(user);
	}

}
