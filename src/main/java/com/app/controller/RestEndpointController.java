package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Employee;
import com.app.service.DashboardService;

@RestController
public class RestEndpointController {
	
	@Autowired
	private DashboardService dashboardService;
	
	@RequestMapping("/employees")
	public List<Employee> getAllEmployee(){
		return dashboardService.getAllEmployee();
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/employee/add" )
	public Employee saveEmployee(@RequestBody Employee employee) {
		return dashboardService.addEmployee(employee);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/employee/delete" )
	public String deleteEmployee(@RequestParam(name="empId", required=true) String empId) {
		
		Long id = Long.parseLong(empId);
		
		try {
			dashboardService.deleteEmployee(dashboardService.getEmployee(id));
			return "deleted";
		} catch (Exception e) {
			return "error";
		}
	}
	
}
