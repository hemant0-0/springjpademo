package com.springjpa.springjpademo.controller;

import com.springjpa.springjpademo.model.Employee;
import com.springjpa.springjpademo.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepo employeeRepo;

    @PostMapping("/saveEmp")
    public String saveEmployee(@RequestBody Employee employee){
        employeeRepo.save(employee);
        return "Employee Save";
    }
    @GetMapping("/getallEmployees")
    public List<Employee> getEmployee(){
    return employeeRepo.findAll();
    }

    @GetMapping("/getEmployee/{id}")
    public Optional<Employee> getEmployee(@PathVariable Integer id){
        return employeeRepo.findById(id);
    }

    @PutMapping("/updateemployee}")
    public String updateEmp(@RequestBody Employee employee){
    Optional<Employee> emp=employeeRepo.findById(employee.getId());
    if(emp.isPresent()){
        emp.get().setLastName(employee.getLastName());
        emp.get().setCity(employee.getCity());
        employeeRepo.save(emp.get());
        return "update";
    }
    return "record Not found";
    }

    @GetMapping("/deleteEmp/{id}")
    public String deleteEmployee(@PathVariable Integer id){
        employeeRepo.deleteById(id);
        return "Employee Deleted";
    }


}
