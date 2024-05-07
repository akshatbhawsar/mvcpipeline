package com.nagarro.employeemanagement.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nagarro.employeemanagement.model.Employee;
import com.nagarro.employeemanagement.service.EmployeesListService;
import com.nagarro.employeemanagement.service.UserAuthenticationService;

@Controller
public class UserActivityController {
	@Autowired
	EmployeesListService eServices;
	@Autowired
	UserAuthenticationService auth;

	@RequestMapping("/requestAddEmp")
	public String addEmployees(Model model) {

		return "AddEmployeesDetail.jsp";
	}

	@RequestMapping("/requestEditEmp")
	public String editEmployees(Model model, @RequestParam("id") int id) {
		Employee emp = eServices.findEmpById(id);

		model.addAttribute("emp", emp);

		return "EditEmployeeDetails.jsp";
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.setAttribute("username", null);
		return "index.jsp";
	}

	@RequestMapping("/requestSignup")
	public String requestSignup() {
		return "signup.jsp";
	}

	@RequestMapping(value = "/requestLogin", method = RequestMethod.POST)
	public String login(@RequestParam("username") String name, @RequestParam("password") String password, Model model,
			HttpSession session) {
		if (auth.isAuthenticate(name, password)) {
			List<Employee> elist = eServices.getListFromAPI();
			model.addAttribute("empList", elist);
			session.setAttribute("username", name);
			return "EmployeesList.jsp";
		} else {
			model.addAttribute("msg", "Invalid Username Or Password");
			return "errorpage.jsp";
		}

	}

}
