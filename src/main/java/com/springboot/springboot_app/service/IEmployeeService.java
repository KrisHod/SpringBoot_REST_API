package com.spring.rest.service;

import com.spring.rest.entity.Employee;

import java.util.List;

public interface IEmployeeService {
    public List<Employee> getAll();

    public void save(Employee employee);

    public Employee getById(int id);

    public void deleteById(int id);
}
