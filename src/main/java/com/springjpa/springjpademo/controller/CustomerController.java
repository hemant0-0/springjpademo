package com.springjpa.springjpademo.controller;

import com.springjpa.springjpademo.model.Customer;
import com.springjpa.springjpademo.model.Employee;
import com.springjpa.springjpademo.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class CustomerController {

    @Autowired
    private CustomerRepo customerRepo;

    @PostMapping("/savecustomer")
    public String saveCustomer(@RequestBody Customer customer){
        customerRepo.save(customer);
        return "Customer save ";
    }
    @GetMapping("/allcustomer")
    public List<Customer> getall(){
        return customerRepo.allcustomer();
    }



}
