package com.personalProject.Enterprise_employees_management_system.service;

import com.personalProject.Enterprise_employees_management_system.dao.EmployeeDAO;
import com.personalProject.Enterprise_employees_management_system.entity.Departament;
import com.personalProject.Enterprise_employees_management_system.entity.Employee;
import com.personalProject.Enterprise_employees_management_system.entity.EmployeeDetail;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

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
    public Employee findById(int theId) {
        return employeeDAO.findById(theId);
    }

    @Override
    @Transactional
    public List<Employee> getEmployeeByDepartament(Departament departament) {

        final List<Employee> employees = employeeDAO.findAll();

        return employees.stream()
                .filter(employee -> employee.getDepartament()
                        .equals(departament))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void save(Employee theEmployee) {

        EmployeeDetail employeeDetail = new EmployeeDetail();
        employeeDetail.setSalary(theEmployee.getEmployeeDetail().getSalary());
        employeeDetail.setAddress(theEmployee.getEmployeeDetail().getAddress());
        //set child refference
        theEmployee.setEmployeeDetail(employeeDetail);
        //Set parent reference
        employeeDetail.setEmployee(theEmployee);

        employeeDAO.save(theEmployee);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        employeeDAO.deleteById(theId);
    }

}
