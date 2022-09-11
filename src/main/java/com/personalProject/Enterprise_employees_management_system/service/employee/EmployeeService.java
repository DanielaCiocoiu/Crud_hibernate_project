package com.personalProject.Enterprise_employees_management_system.service.employee;

import com.personalProject.Enterprise_employees_management_system.domain.Departament;
import com.personalProject.Enterprise_employees_management_system.domain.Employee;

import java.util.List;

public interface EmployeeService {
     List<Employee> findAll();
     Employee findById(int theId);
     void save(Employee theEmployee);
     void deleteById(int theId);
     List<Employee>  getEmployeeByDepartament(Departament departament);

}
