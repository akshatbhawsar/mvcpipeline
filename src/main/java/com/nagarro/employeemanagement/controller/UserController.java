package com.nagarro.employeemanagement.controller;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nagarro.employeemanagement.model.Employee;
import com.nagarro.employeemanagement.service.EmployeesListService;
import com.nagarro.employeemanagement.service.UserAuthenticationService;
/**
 * Controller for the App
 * @author akshatBhawsar
 *
 */
@Controller
public class UserController {

	@Autowired
	UserAuthenticationService auth;
	@Autowired
	EmployeesListService eServices;

	@RequestMapping(value = "/addEmp", method = RequestMethod.POST)
	public String submitEmployeeDetail(@ModelAttribute Employee emp, Model model) throws ParseException {

		String status = eServices.addEmployee(emp);
		List<Employee> elist = eServices.getListFromAPI();
		model.addAttribute("empList", elist);
		model.addAttribute("Status", status);
		return "EmployeesList.jsp";
	}

	@RequestMapping(value = "/editEmp", method = RequestMethod.POST)
	public String editEmployeeDetail(@ModelAttribute Employee emp, Model model, @RequestParam("id") int id) {

		emp.setEmployeeCode(id);

		String status = eServices.editEmployees(emp.getEmployeeCode(), emp);
		List<Employee> elist = eServices.getListFromAPI();
		model.addAttribute("Status", status);
		model.addAttribute("empList", elist);
		return "EmployeesList.jsp";

	}

	@RequestMapping("/deleteEmp")
	public String deleteEmp(@RequestParam("id") int id, Model model) {

		String status = eServices.deleteEmployee(id);
		List<Employee> elist = eServices.getListFromAPI();
		model.addAttribute("empList", elist);
		model.addAttribute("Status", status);
		return "EmployeesList.jsp";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signup(@RequestParam("username") String name, @RequestParam("password") String password, Model model,
			HttpSession session) {

		String status = auth.addUser(name, password);
		List<Employee> elist = eServices.getListFromAPI();
		model.addAttribute("Status", status);
		model.addAttribute("empList", elist);
		session.setAttribute("username", name);
		return "EmployeesList.jsp";
	}

	

}
