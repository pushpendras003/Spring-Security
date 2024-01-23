package com.example.model;

import java.util.Collections;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {
	private String name;
	@Id
	private String id;
	private String password;
	private String role;
	public String getName() {
		return name;
	}
	public List<GrantedAuthority> getAuthorities() {
        // You should implement this method to return the user's roles/authorities
        // For simplicity, you can return a list with a single role ("ROLE_USER") for now
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));
    }
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPasswordl() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public User(String name, String id, String password, String role) {
		super();
		this.name = name;
		this.id = id;
		this.password = password;
		this.role = role;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", id=" + id + ", password=" + password + ", role=" + role + "]";
	}
	
	
}
