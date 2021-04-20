package com.springjpa.springjpademo.controller;

import com.springjpa.springjpademo.model.Product;
import com.springjpa.springjpademo.repository.ProductRepo;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductRepo productRepo;

    @PostMapping("/saveproduct")
    public String saveProduct(@RequestBody Product product){
        productRepo.save(product);
        return "Save Product";
    }

    @GetMapping("/getunsoldproducts")
    public List<Product> getUnsoldProducts(){
        return productRepo.findAllUnsoldProduct();
    }
}
