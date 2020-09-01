package com.app.service.impl;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Employee;
import com.app.entity.OrderReceived;
import com.app.entity.OrderStatus;
import com.app.entity.ProductCategory;
import com.app.entity.Revenue;
import com.app.repo.EmployeeRepo;
import com.app.repo.OrderReceivedRepo;
import com.app.repo.OrderStatusRepo;
import com.app.repo.ProductCategoryRepo;
import com.app.repo.RevenueRepo;
import com.app.service.DashboardService;

@Service
public class DashboardServiceImpl implements DashboardService{
	
	@Autowired
	private RevenueRepo revenueRepo;
	
	@Autowired
	private EmployeeRepo employeeRepo;
	
	@Autowired
	private OrderStatusRepo orderStatusRepo;
	
	@Autowired
	private OrderReceivedRepo orderReceivedRepo;
	
	@Autowired
	private ProductCategoryRepo productCategoryRepo;

//	@Override
//	public List<Revenue> getTodayRevenueDash() {
//		return revenueRepo.findAll();
//	}
	
	@Override
	public HashMap<String, Object> getTodayRevenueDash(){
		HashMap<String, Object> populateRevenue = new HashMap<>();
		
		List<Revenue> revenueList = revenueRepo.findAll();
		
		// Build labels and revenue
		List<String> label = new ArrayList<>();
		List<String> _revenue = new ArrayList<>();
		double totalMargin = 0;
		double totalExpense = 0;
		double totalRevenue = 0;
		
		Locale locale = new Locale("en", "US");
		NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
		
		for (Revenue revenue : revenueList) {
			label.add(revenue.get_month());
			_revenue.add(String.valueOf(revenue.getRevenue()));
			totalExpense += revenue.getExpense();
			totalMargin += revenue.getMargins();
			totalRevenue += revenue.getRevenue();
		}
		
		populateRevenue.put("crLabels", label.toString());
		populateRevenue.put("crRevenue", _revenue.toString());
		populateRevenue.put("totalExpense", currencyFormatter.format(totalExpense));
		populateRevenue.put("totalMargin", currencyFormatter.format(totalMargin));
		populateRevenue.put("totalRevenue", currencyFormatter.format(totalRevenue));
		
		return populateRevenue;		
	}
	
	
	@Override
	public List<ProductCategory> getBestCategory(){
		return productCategoryRepo.findByBestCategory(true);
	}
	
	@Override
	public List<OrderReceived> getAllOrderReceived(){
		return orderReceivedRepo.findAll();
	}
	
	@Override
	public List<OrderStatus> getOrderCollection(){
		return orderStatusRepo.findAll();
	}

	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepo.findAll();
	}

	@Override
	public Employee addEmployee(Employee employee) {
		return employeeRepo.save(employee);
		
	}

	@Override
	public Employee updateEmployee(Employee employee) {		
		return employeeRepo.save(employee);		
	}

	@Override
	public void deleteEmployee(Employee employee) {
		employeeRepo.delete(employee);
		
	}

	@Override
	public Employee getEmployee(Long id) {
		return employeeRepo.getOne(id);
	}
	
	
}
