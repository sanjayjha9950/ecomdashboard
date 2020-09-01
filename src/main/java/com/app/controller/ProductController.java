package com.app.controller;

import com.app.entity.Products;
import com.app.repo.ProductsRepo;
import com.app.service.ProductsService;
import com.app.service.impl.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    ProductsService productsService;
    @Autowired
    FileService fileService;
    @Autowired
    ProductsRepo productsRepo;

    @GetMapping("/listProducts")
    public ModelAndView listProducts(){
        List<Products> productsList = productsRepo.findAll();
        ModelAndView mav = new ModelAndView("/productList");
        mav.addObject("products",productsList);
        return mav;
    }

    @GetMapping("/addProduct")
    public ModelAndView addProduct()
    {
        ModelAndView addProduct = new ModelAndView("/addProduct");
        Products products = new Products();
        products.setPrice(null);
        products.setDiscount(null);
        addProduct.addObject("product",products);
        //addProduct.addObject("image",new MultipartFile())
        return addProduct;
    }

    @PostMapping("/saveProduct")
    public ModelAndView saveProduct(@RequestParam("image") MultipartFile file, @ModelAttribute Products products){
        //System.out.println(products.getDescription());
        if (!file.getOriginalFilename().isEmpty()) {
            fileService.uploadFile(file, products.getCode());
            products.setImageName(products.getCode());
        }
        else
            products.setImageName("defaultProduct.jpg");
        productsRepo.save(products);
        List<Products> productsList = productsRepo.findAll();
        ModelAndView mav = new ModelAndView("/dashboard");
        mav.addObject("products",productsList);
        return mav;
    }

    @GetMapping("/product/delete/{id}")
    public ModelAndView deleteProduct(@PathVariable Integer id){
        productsRepo.deleteById(id);
        return listProducts();
    }
}
