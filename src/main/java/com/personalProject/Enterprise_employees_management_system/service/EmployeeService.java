package com.personalProject.Enterprise_employees_management_system.service;

import com.personalProject.Enterprise_employees_management_system.entity.Departament;
import com.personalProject.Enterprise_employees_management_system.entity.Employee;

import java.util.List;

public interface EmployeeService {
     List<Employee> findAll();
     Employee findById(int theId);
     void save(Employee theEmployee);
     void deleteById(int theId);

     List<Employee>  getEmployeeByDepartament(Departament departament);


}
