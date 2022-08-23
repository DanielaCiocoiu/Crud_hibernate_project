package com.personalProject.Crud_hibernate_project.dao;

import com.personalProject.Crud_hibernate_project.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeDAO {
        List<Employee> findAll();
        Employee findById(int theId);
        void save(Employee theEmployee);
        void deleteById(int theId);
        List<Employee>  getEmployeeByDepartament();
}
