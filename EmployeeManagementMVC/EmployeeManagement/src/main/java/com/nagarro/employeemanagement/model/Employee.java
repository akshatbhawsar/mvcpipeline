package com.nagarro.employeemanagement.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * model class for Employee
 * @author akshatBhawsar
 *
 */
public class Employee {

	private int employeeCode;
	private String name;
	private String birthDate;
	private String email;
	private String location;

	public int getEmployeeCode() {
		return employeeCode;
	}

	public String getName() {
		return name;
	}

	public String getbirthDate() {
		return birthDate;
	}

	public String getEmail() {
		return email;
	}

	public String getLocation() {
		return location;
	}

	public void setEmployeeCode(int employeeCode) {
		this.employeeCode = employeeCode;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBirthDate(String dob) {
		this.birthDate = dob;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getDateFromString(String date) throws ParseException {
		Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(date);
		return date1;
	}

	public String getDateString(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String strDate = formatter.format(date);
		return strDate;
	}

	public Employee(int employeeCode, String name, String birthDate, String email, String location) {
		super();
		this.employeeCode = employeeCode;
		this.name = name;
		this.birthDate = birthDate;
		this.email = email;
		this.location = location;
	}

	public Employee() {

	}

}
