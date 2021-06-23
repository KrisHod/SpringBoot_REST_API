package com.spring.rest.repository;

import com.spring.rest.entity.Employee;

import java.util.List;

public interface IEmployeeRepository {
    public List<Employee> getAll();

    public void saveEmployee(Employee employee);

    public Employee getById(int id);

    public void deleteById(int id);
}
