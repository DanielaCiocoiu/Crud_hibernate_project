package com.personalProject.Enterprise_employees_management_system.service;

import com.personalProject.Enterprise_employees_management_system.dao.EmployeeDAO;
import com.personalProject.Enterprise_employees_management_system.entity.Departament;
import com.personalProject.Enterprise_employees_management_system.entity.Employee;
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
//mvn clean verify
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
    @Test
    void getOnlyItDepartaments() {
        final List<Employee> mockEmployees = getEmployeesMockList();

        when(employeeDAO.findAll()).thenReturn(mockEmployees);
        final List<Employee> employeesHR = employeeService.getEmployeeByDepartament(Departament.HR);

        final List<Employee> expectedEmployeesIt = new ArrayList<>();
        expectedEmployeesIt.add(new Employee("Yuri", "Petrov", "yuri@gmail.com", Departament.HR, new Date(1970-10-05)));

        assertEquals(0, employees.size());
        assertEquals(1, employeesHR.size());
        assertEquals(expectedEmployeesIt, employeesHR);

    }

    //FIXME


    private List<Employee> getEmployeesMockList() {
        final List<Employee> mockEmployees = new ArrayList<>();
        mockEmployees.add(new Employee("Ana", "Irina", "ana@yahoo.com", Departament.IT, new Date(1970-10-05)));
        mockEmployees.add(new Employee("Yuri", "Petrov", "yuri@gmail.com", Departament.HR, new Date(1970-10-05)));
        mockEmployees.add(new Employee("iON", "Mihalcea", "ion@yahoo.com", Departament.FINANCE, new Date(1970-10-05)));

        return mockEmployees;
    }

}
