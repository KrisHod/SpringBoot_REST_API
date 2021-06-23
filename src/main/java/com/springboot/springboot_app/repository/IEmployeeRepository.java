package com.springboot.springboot_app.repository;



import com.springboot.springboot_app.entity.Employee;

import java.util.List;

public interface IEmployeeRepository {
    public List<Employee> getAll();

    public void saveEmployee(Employee employee);

    public Employee getById(int id);

    public void deleteById(int id);
}
