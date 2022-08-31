package com.personalProject.Enterprise_employees_management_system.service;

import com.personalProject.Enterprise_employees_management_system.dao.EmployeeDAO;
import com.personalProject.Enterprise_employees_management_system.entity.Departament;
import com.personalProject.Enterprise_employees_management_system.entity.Employee;
import com.personalProject.Enterprise_employees_management_system.entity.EmployeeDetail;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class EmployeeServiceImplTests {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EmployeeDAO employeeDAO;
    List<Employee> employees;

    @BeforeEach
    public void beforeEachTestExecution() {
        employees = new ArrayList<>();
        System.out.println("Before each test execution: ");
    }

    @Test
    void getAll() {
        employees = employeeService.findAll();
        assertEquals(12, employees.size());

    }
    @Test
    void getOnlyHRDepartaments() {
       final List<Employee> employeesIt = employeeService.getEmployeeByDepartament(Departament.HR);
       assertEquals(5, employeesIt.size());

    }
    @Test
    void getById() {
        Employee employee = getEmployee();
        employee.setId(1);
        employeeService.save(employee);
       Employee actual  = employeeService.findById(employee.getId());
        assertEquals(employee.getId(), actual.getId());
    }

    @Test
    void saveEmployee() {
        Employee employee = getEmployee();
        employee.setId(1);
        employeeService.save(employee);

        Employee found = employeeService.findById(employee.getId());
        assertEquals(employee.getId(), found.getId());
    }

    @Test
    void deleteEmployee() {
        Employee employee = getEmployee();
        employee.setId(1);
        employeeService.save(employee);
        employeeService.deleteById(employee.getId());

        List<Employee> result = new ArrayList<>();
        employeeService.findAll().forEach(e -> result.add(e));
        assertEquals(result.size(), 11);
    }


    private Employee getEmployee() {
        Employee employee = new Employee();
        employee.setFirstName("Irinel");
        employee.setLastName("Nicolescu");
        employee.setEmail("irinel@yahoo.com");
        employee.setDateOfBirth(new Date(1988-10-05));
        employee.setDepartament(Departament.IT);
        employee.setEmployeeDetail(new EmployeeDetail(1, 5000, "Micsunelelor", new Employee()));
        return employee;
    }

}
