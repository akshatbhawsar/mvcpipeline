package com.nagarro.employeemanagement.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.nagarro.employeemanagement.constants.Constants;
import com.nagarro.employeemanagement.model.Employee;
/**
 * 
 * @author akshatBhawsar
 * provide all the data of Employees from API s
 *
 */
@Component
public class EmployeesListService {

	@Autowired
	RestTemplate rest;
/**
 * 
 * @return List of Employees
 */
	public List<Employee> getListFromAPI() {

		String url = Constants.URL;

		Employee[] eArray = rest.getForObject(url, Employee[].class);

		List<Employee> eList = Arrays.asList(eArray);

		return eList;
	}

	/**
	 * used to add employee
	 * @param emp
	 * @return msg
	 */
	public String addEmployee(Employee emp) {
		String url = Constants.URL;
		try {
			Employee createdUser = rest.postForObject(url, emp, Employee.class);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "Added";
	}

	/**
	 * used to edit the employee
	 * @param id
	 * @param emp
	 * @return msg
	 */
	public String editEmployees(int id, Employee emp) {
		String url = Constants.IDURL + id;
		rest.put(url, emp, Employee.class);

		return "Edited";
	}

	/**
	 * used to delete the Employee
	 * @param id
	 * @return
	 */
	public String deleteEmployee(int id) {

		String url = Constants.IDURL + id;

		rest.delete(url);
		return "Deleted";

	}
/**
 * used for find employees by id's
 * @param id
 * @return
 */
	public Employee findEmpById(int id) {

		String url = Constants.IDURL + id;

		Employee emp = rest.getForObject(url, Employee.class);
		return emp;
	}

	
}
