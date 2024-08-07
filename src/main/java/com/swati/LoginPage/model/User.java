package com.swati.LoginPage.model;
import java.util.*;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name="user",uniqueConstraints=@UniqueConstraint(columnNames="email"))
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="First Name")
	private String firstName;
	
	@Column(name="Last Name")
	private String LastName;
	
	@Column(name="email")
	private String email;
	
	@Column(name="Password")
	private String password;
	
	@ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinTable(
			name="user_roles",
			joinColumns=@JoinColumn(
					name="user_id",referencedColumnName="id"),
			inverseJoinColumns=@JoinColumn(
					name="role_id",referencedColumnName="id"))				       
	private Collection<Role> roles;
	
	public User() {
		
	}
	public User(String firstName, String lastName, String password, Collection<Role> roles, String email) {
		super();
		this.firstName = firstName;
		LastName = lastName;
		this.password = password;
		this.email=email;
		this.roles = roles;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getEmail() {
		return firstName;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Collection<Role> getRoles() {
		return roles;
	}
	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}
	

}
