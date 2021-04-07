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
//   @PutMapping("/updateemployee")
//    public String updateEmployee(){
//    return employeeRepo.
//    }

    @PutMapping("/updateemployee/{id}")
    public ResponseEntity<Object> getEmployee(@RequestBody Employee employee, @PathVariable Integer id){
    Optional<Employee> emp=employeeRepo.findById(id);
    if(!emp.isPresent())
        return ResponseEntity.notFound().build();
        employee.setFirstName(id);

    return null;
    }

    @GetMapping("/deleteEmp/{id}")
    public String deleteEmployee(@PathVariable Integer id){
        employeeRepo.deleteById(id);
        return "Employee Deleted";
    }


}
