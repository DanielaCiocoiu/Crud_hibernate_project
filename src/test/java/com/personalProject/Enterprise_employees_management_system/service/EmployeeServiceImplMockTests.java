package com.personalProject.Enterprise_employees_management_system.service;

import com.personalProject.Enterprise_employees_management_system.dao.EmployeeDAO;
import com.personalProject.Enterprise_employees_management_system.entity.Departament;
import com.personalProject.Enterprise_employees_management_system.entity.Employee;
import com.personalProject.Enterprise_employees_management_system.entity.EmployeeDetail;
import org.junit.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class EmployeeServiceImplMockTests {

    Logger log = Logger.getLogger(this.getClass().getName());

    @Autowired
    private EmployeeService employeeService;

    @MockBean
    private EmployeeDAO employeeDAO;

    List<Employee> employees;

    @BeforeEach
    public void beforeEachTestExecution() {
        employees = new ArrayList<>();
        System.out.println("Before each test execurion");
    }

    @Test
    void getAll() {
        List<Employee> mockEmployees = getEmployeesMockList();

        when(employeeDAO.findAll()).thenReturn(mockEmployees);
        employees = employeeService.findAll();

        assertEquals(3, employees.size());

    }
    @Ignore
    @Test
     void getOnlyHRDepartaments() {
        final List<Employee> mockEmployees = getEmployeesMockList();

        when(employeeDAO.findAll()).thenReturn(mockEmployees);
        final List<Employee> actual = employeeService.getEmployeeByDepartament(Departament.HR);

        final List<Employee> expected = new ArrayList<>();
        EmployeeDetail employeeDetail = new EmployeeDetail();
        employeeDetail.setSalary(5000);
        employeeDetail.setAddress("Londra");
        employeeDetail.setEmployee(new Employee());
        expected.add(new Employee(1, "Maria", "Petrov", "yuri@gmail.com", Departament.HR, new Date(1970-10-05), employeeDetail));
        assertEquals(1, actual.size());
        assertEquals(expected, actual);

    }

    //FIXME


    private List<Employee> getEmployeesMockList() {
        final List<Employee> mockEmployees = new ArrayList<>();
        mockEmployees.add(new Employee(1,"Ana", "Irina", "ana@yahoo.com", Departament.IT, new Date(1970-10-05), new EmployeeDetail(1,5000, "Paris", new Employee())));
        mockEmployees.add(new Employee(2,"Maria", "Petrov", "yuri@gmail.com", Departament.HR, new Date(1970-10-05),new EmployeeDetail(2,5000, "Londra", new Employee())));
        mockEmployees.add(new Employee(3,"iON", "Mihalcea", "ion@yahoo.com", Departament.FINANCE, new Date(1970-10-05), new EmployeeDetail(3,5000, "Milano", new Employee())));

        return mockEmployees;
    }

}
