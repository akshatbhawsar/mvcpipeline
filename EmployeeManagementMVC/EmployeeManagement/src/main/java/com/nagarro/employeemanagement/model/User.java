package com.nagarro.employeemanagement.model;

import javax.persistence.Entity;

import javax.persistence.Id;
/**
 * Model class for User and Also  database Table
 * @author akshatBhawsar
 *
 */
@Entity
public class User {

	@Id
	private String userName;
	private String password;

	public User(String userName, String password) {
		super();

		this.userName = userName;
		this.password = password;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "User [ userName=" + userName + ", password=" + password + "]";
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
