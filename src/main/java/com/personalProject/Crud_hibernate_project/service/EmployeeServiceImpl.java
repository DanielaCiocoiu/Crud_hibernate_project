package com.personalProject.Crud_hibernate_project.service;

import com.personalProject.Crud_hibernate_project.dao.EmployeeDAO;
import com.personalProject.Crud_hibernate_project.entity.Departament;
import com.personalProject.Crud_hibernate_project.entity.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeDAO employeeDAO;

    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    @Transactional
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    @Transactional
    public Optional<Employee> findById(int theId) {
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

    @Override
    @Transactional
    public  List<Employee>  getEmployeeByDepartament(Departament departament) {

        final  List<Employee>  employees = employeeDAO.findAll();

        return employees.stream()
                .filter(employee -> employee.getDepartament()
                .equals(departament))
                .collect(Collectors.toList());

    }
}
