package com.simplilearn.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import com.simplilearn.repo.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.simplilearn.dto.UserRegistrationDto;
import com.simplilearn.model.Role;
import com.simplilearn.model.User;
import com.simplilearn.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService{
 
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepo roleRepo;


	@Autowired
	@Lazy
	private BCryptPasswordEncoder passwordEncoder;
		
	
	@Override
	public User save(UserRegistrationDto dto) {
		User user= new User(dto.getFirstName(), dto.getLastName(), dto.getEmail(),passwordEncoder.encode(dto.getPassword()),dto.getGender(),dto.getPhone(),Arrays.asList(roleRepo.findByName("ROLE_USER")));
		return userRepository.save(user);
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user=userRepository.findByEmail(email);
		if (user==null) {
			throw new UsernameNotFoundException("Invalid Username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(), mapRoleIntoAuthorities(user.getRoles()));
	}
	
	private Collection<? extends GrantedAuthority> mapRoleIntoAuthorities(Collection<Role> roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
		
	}

}
