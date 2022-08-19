package com.personalProject.Crud_hibernate_project.service;

import com.personalProject.Crud_hibernate_project.dao.EmployeeDAO;
import com.personalProject.Crud_hibernate_project.entity.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImple implements EmployeeService{

    private EmployeeDAO employeeDAO;

    public EmployeeServiceImple(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    @Transactional
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    @Transactional
    public Employee findById(int theId) {
        return employeeDAO.findById(theId);
    }

    @Override
    @Transactional
    public void save(Employee theEmployee) {
        employeeDAO.save(theEmployee );
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        employeeDAO.deleteById(theId );
    }
}
