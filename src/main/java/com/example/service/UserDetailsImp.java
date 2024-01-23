package com.example.service;

import java.util.Collection;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.model.User;
import com.example.repo.UserRepositoryImpl;

@Service
public class UserDetailsImp implements UserDetailsService{
	@Autowired
	private UserRepositoryImpl userRepository;
	
	@Autowired
    private PasswordEncoder passwordEncoder;

    public UserDetailsImp() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User loadedUser = userRepository.findByName(username);
        if(loadedUser==null) {
        	throw new UsernameNotFoundException("Could not found a user with given name");
        	
        }
        return new org.springframework.security.core.userdetails.User(
                loadedUser.getName(),
                loadedUser.getPasswordl(),
                true,
                true,
                true,
                true,
                loadedUser.getAuthorities())
        ;
    }
	

}
