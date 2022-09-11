package com.personalProject.Enterprise_employees_management_system.service.employee;

import com.personalProject.Enterprise_employees_management_system.domain.Departament;
import com.personalProject.Enterprise_employees_management_system.domain.Employee;
import com.personalProject.Enterprise_employees_management_system.domain.EmployeeDetail;
import com.personalProject.Enterprise_employees_management_system.domain.Phone;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private static final Logger logger
            = LoggerFactory.getLogger(EmployeeServiceImpl.class);

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
        EmployeeDetail employeeDetail = theEmployee.getEmployeeDetail();

        //set child refference
        theEmployee.setEmployeeDetail(employeeDetail);
        //Set parent reference
        employeeDetail.setEmployee(theEmployee);

        employeeDAO.save(theEmployee);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        Employee employee1 = employeeDAO.findById(theId);
        EmployeeDetail employeeDetail = employee1.getEmployeeDetail();

        //set child refference
        employee1.setEmployeeDetail(employeeDetail);
        //Set parent reference
        employeeDetail.setEmployee(employee1);

        Phone phone = employee1.getPhones().get(0);
        employee1.removePhone(phone);

        employeeDetail.getEmployee().setEmployeeDetail(null);
        employeeDAO.deleteById(theId);
    }
}
