package com.simplilearn.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.simplilearn.dto.UserRegistrationDto;
import com.simplilearn.model.User;

public interface UserService extends UserDetailsService{
	User save(UserRegistrationDto dto);
}
