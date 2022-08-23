package com.personalProject.Crud_hibernate_project.service;

import com.personalProject.Crud_hibernate_project.entity.Departament;
import com.personalProject.Crud_hibernate_project.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
     List<Employee> findAll();
     Employee findById(int theId);
     void save(Employee theEmployee);
     void deleteById(int theId);

     List<Employee>  getEmployeeByDepartament(Departament departament);


}
