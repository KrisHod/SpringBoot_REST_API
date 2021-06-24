package com.springboot.springboot_app.repository;


import com.springboot.springboot_app.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeRepository implements IEmployeeRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Employee> getAll() {

        Query query = entityManager.createQuery("from Employee");
        List<Employee> allEmployees = query.getResultList();
        return allEmployees;
    }

    @Override
    public void saveEmployee(Employee employee) {
        Employee newEmployee = entityManager.merge(employee);
        employee.setId((newEmployee.getId()));
    }

    @Override
    public Employee getById(int id) {

        Employee employee = entityManager.find(Employee.class, id);
        return employee;
    }

    @Override
    public void deleteById(int id) {
        Query query = entityManager.createQuery("delete from Employee " +
                "where id= :employeeId");
        query.setParameter("employeeId", id);
        query.executeUpdate();
    }
}
