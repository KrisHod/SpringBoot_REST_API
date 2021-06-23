package com.springboot.springboot_app.service;


import com.springboot.springboot_app.entity.Employee;

import java.util.List;

public interface IEmployeeService {
    public List<Employee> getAll();

    public void save(Employee employee);

    public Employee getById(int id);

    public void deleteById(int id);
}
