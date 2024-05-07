package com.nagarro.employeemanagement.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.nagarro.employeemanagement.constants.Constants;
import com.nagarro.employeemanagement.model.User;
/**
 * Database layer for thr App
 * @author akshatBhawsar
 *
 */
@Component
public class AuthenticationDao {

	@Autowired
	HibernateTemplate hibernateTemplate;

	@SuppressWarnings("unchecked")

	/**
	 * 
	 * @param username
	 * @param password
	 * @return users
	 */
	public List<User> getUsers(String username, String password) {

		try {
			List<User> users = new ArrayList<User>();

			users = (List<User>) hibernateTemplate.findByNamedParam(Constants.FIND_USER_HQL_QUERY,
					new String[] { "username", "password" }, new Object[] { username, password });

			return users;

		}

		catch (Exception e) {

			e.printStackTrace();
			return null;
		}

	}
/**
 * Used to Add new User for the application
 * @param user
 */
	@Transactional
	public void addUser(User user) {

		try {
			hibernateTemplate.save(user);
			System.out.println(user.getUserName());

		} catch (Exception e) {
			System.out.println("hi am i called");
			e.printStackTrace();

		}
	}

}
