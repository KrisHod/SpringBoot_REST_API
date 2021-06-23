package com.spring.rest.controller;

import com.spring.rest.entity.Employee;
import com.spring.rest.exception.EmployeeIncorrectData;
import com.spring.rest.exception.NoSuchEmployeeException;
import com.spring.rest.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
        Employee employee = employeeService.getById(id);

        if (employee == null) {
            throw new NoSuchEmployeeException("There is no employee with ID = " + id + " in DB");
        }
        return employee;
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
        if (employee == null) {
            throw new NoSuchEmployeeException("There is no employee with ID = " + id + " in DB");
        }

        employeeService.deleteById(id);
        return "Employee with ID = " + id + " was deleted.";
    }
}
