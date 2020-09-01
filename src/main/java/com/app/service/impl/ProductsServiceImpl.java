package com.app.service.impl;

import com.app.entity.Products;
import com.app.repo.ProductsRepo;
import com.app.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductsServiceImpl implements ProductsService {

    @Autowired
    ProductsRepo productsRepo;
    @Override
    public List<Products> listAllProducts() {
        List<Products> productsList = new ArrayList<>();
        productsList = productsRepo.findAll();
        return productsList;
    }
}
