package com.app.service;

import java.util.HashMap;
import java.util.List;

import com.app.entity.Employee;
import com.app.entity.OrderReceived;
import com.app.entity.OrderStatus;
import com.app.entity.ProductCategory;
import com.app.entity.Revenue;


public interface DashboardService {
	
	HashMap<String, Object> getTodayRevenueDash();

	List<ProductCategory> getBestCategory();

	List<OrderReceived> getAllOrderReceived();

	List<OrderStatus> getOrderCollection();
	
	List<Employee> getAllEmployee();
	
	Employee addEmployee(Employee employee);
	
	Employee updateEmployee(Employee employee);
	
	void deleteEmployee(Employee employee);
	
	Employee getEmployee(Long id);
}
