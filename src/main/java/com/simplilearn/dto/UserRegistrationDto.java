package com.simplilearn.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserRegistrationDto {

	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String gender;
	private String phone;
}
