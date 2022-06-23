package com.simplilearn.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "user", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String gender;
	private String phone;
	
	@ManyToMany(
			fetch = FetchType.EAGER,
			cascade = CascadeType.ALL
			)
	@JoinTable(
			name = "users_roles",
			joinColumns = @JoinColumn(
					name="user_id",referencedColumnName = "id"
					),
			inverseJoinColumns = @JoinColumn(
					name="role_id",referencedColumnName = "id"
					)
			)
	private Collection<Role> roles;


	public User(String firstName, String lastName, String email, String password, String gender, String phone, Collection<Role> roles) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.phone = phone;
		this.roles = roles;
	}
}
