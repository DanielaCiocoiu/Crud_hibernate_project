package com.personalProject.Crud_hibernate_project.service;

import com.personalProject.Crud_hibernate_project.dao.EmployeeDAO;
import com.personalProject.Crud_hibernate_project.entity.Departament;
import com.personalProject.Crud_hibernate_project.entity.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class EmployeeServiceImplTests {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EmployeeDAO employeeDAO;
    List<Employee> employees;

    @BeforeEach
    public void beforeEachTestExecution() {
        employees = new ArrayList<>();
        System.out.println("Before each test execurion");
    }

    @Test
    void getAll() {
        employees = employeeService.findAll();
        assertEquals(7, employees.size());

    }
    @Test
    void getOnlyHRDepartaments() {
       final List<Employee> employeesIt = employeeService.getEmployeeByDepartament(Departament.HR);
       assertEquals(3, employeesIt.size());

    }
    @Test
    void getById() {
       Employee employee = employeeService.findById(2);
        assertEquals(2, employee.getId());
    }

}
