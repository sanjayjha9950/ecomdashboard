package com.app.controller;

import com.app.beans.StatusCodes;
import com.app.entity.Products;
import com.app.entity.User;
import com.app.service.LoginService;
import com.app.service.ProductsService;
import com.app.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.app.service.DashboardService;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

@Controller
public class ThymeleafController {
	
	@Autowired
	private DashboardService dashboardService;
	@Autowired
	LoginService loginService;
	@Autowired
	ProductsService productsService;

	@Autowired
	private RegisterService registerService;
	
	@PostMapping("/dashboard")
	public ModelAndView getDashDetail(@ModelAttribute User user) {
		StatusCodes status = loginService.login(user);
		ModelAndView dashboard = new ModelAndView("/dashboard");
		try {
			List<Products> productsList = productsService.listAllProducts();
			dashboard.addObject("productList",productsList);

		}catch (Exception e){
			System.out.println(e);
		}
		dashboard.addObject("message",status.getMessage());
		/*if (status.equals(200))
			return "/dashboard";*/
		
		return dashboard;
	}
	@GetMapping("/dashboard")
	public ModelAndView showDashboard() {
		//StatusCodes status = loginService.login(user);
		ModelAndView dashboard = new ModelAndView("/dashboard");
		try {
			List<Products> productsList = productsService.listAllProducts();
			dashboard.addObject("products",productsList);

		}catch (Exception e){
			System.out.println(e);
		}
		dashboard.addObject("message","");
		/*if (status.equals(200))
			return "/dashboard";*/

		return dashboard;
	}

	@GetMapping("/signup")
	public ModelAndView signUp(){
		ModelAndView signUp = new ModelAndView("/signup.html");
		signUp.addObject("User", new User());
		return signUp;
	}


	@GetMapping("/login")
	public ModelAndView login(){
		ModelAndView login = new ModelAndView("/login.html");
		login.addObject("title","Cropwheel Login");
		login.addObject("User", new User());
		return login;

	}

	@PostMapping("/register")
	public ModelAndView register(@ModelAttribute User newUser){
		System.out.println(newUser.getfName());
		newUser.setEmail(newUser.getUsername());
		registerService.addUser(newUser);
		ModelAndView login = new ModelAndView("/login.html");
		login.addObject("title","Cropwheel Login");
		login.addObject("User", 	new User());
		return login;
	}


}
