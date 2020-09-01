package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OrderController {

    @GetMapping("/listOrders")
    public ModelAndView listOrders(){
        return null;
    }
}
