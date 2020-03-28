package com.pilyak.testmavenproject.models;

import com.pilyak.testmavenproject.models.Role;

public class UserData {
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private Role role;
	private String password;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getRole() {
		if(role == Role.CLIENT)
			return 1;
		if(role == Role.ADMIN)
			return 2;
		if(role == Role.MANAGER)
			return 3;
		return 1;
	}
	public void setRole(int i) {
		//this.role = role;
		if(i == 1)
			role = Role.CLIENT;
		if(i == 2)
			role = Role.ADMIN;
		if(i == 3)
			role = Role.MANAGER;
	}
	public String getEmail() {
		return email;
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
	@Override
	public String toString() {
		return "UserData [id = " + id + ", firstName = " + firstName + ", lastName = " + lastName + ", e-mail:" + email + ", role = " + role + "]\n";
	}
	
}
