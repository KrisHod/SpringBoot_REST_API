package com.springboot.springboot_app.service;


import com.springboot.springboot_app.entity.Employee;
import com.springboot.springboot_app.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeRepository employeeRepository;

    @Override
    @Transactional
    public List<Employee> getAll() {
        return employeeRepository.getAll();
    }

    @Override
    @Transactional
    public void save(Employee employee) {
        employeeRepository.saveEmployee(employee);
    }

    @Override
    @Transactional
    public Employee getById(int id) {
        return employeeRepository.getById(id);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }
}
