package com.springboot.springboot_app.controller;


import com.springboot.springboot_app.entity.Employee;
import com.springboot.springboot_app.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRESTController {

    @Autowired
    private IEmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> showAll() {
        return employeeService.getAll();
    }

    @GetMapping("/employees/{id}")
    public Employee getById(@PathVariable int id) {

        return employeeService.getById(id);
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        employeeService.save(employee);
        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        employeeService.save(employee);
        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id) {
        Employee employee = employeeService.getById(id);

        employeeService.deleteById(id);
        return "Employee with ID = " + id + " was deleted.";
    }
}
