package com.nagarro.employeemanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nagarro.employeemanagement.dao.AuthenticationDao;
import com.nagarro.employeemanagement.model.User;

/**
 * 
 * @author akshatBhawsar
 *service class for authentications
 */
@Component
public class UserAuthenticationService {

	public UserAuthenticationService() {
	}

	@Autowired
	AuthenticationDao authentication;

	/**
	 * 
	 * @param username
	 * @param password
	 * @return boolean for user if avaliable true or false
	 */
	public boolean isAuthenticate(String username, String password) {
		List<User> users = authentication.getUsers(username, password);

		if (users.size() == 0) {

			return false;
		}

		else
			return true;

	}

	/**
	 * 
	 * @param username
	 * @param password
	 * @return msg
	 */
	public String addUser(String username, String password) {

		User user = new User(username, password);
		authentication.addUser(user);
		return "welcome New User";

	}

}
