package com.personalProject.Crud_hibernate_project.rest;


import com.personalProject.Crud_hibernate_project.entity.Departament;
import com.personalProject.Crud_hibernate_project.entity.Employee;
import com.personalProject.Crud_hibernate_project.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Optional<Employee> getEmployee(@PathVariable int employeeId) {
        Optional<Employee> theEmployee = employeeService.findById(employeeId);
        return theEmployee;
    }

    //http://localhost:8080/api?departament=HR
    @GetMapping
    public List<Employee> getEmployeeDepartament(@RequestParam(value="departament") Departament departament)  {

        List<Employee> theEmployee = employeeService.getEmployeeByDepartament(departament);
        return theEmployee.stream()
                .filter(employee -> employee.getDepartament()
                        .equals(departament))
                .collect(Collectors.toList());
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee) {
        theEmployee.setId(0);
        employeeService.save(theEmployee);
        return theEmployee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee) {

        employeeService.save(theEmployee);
        return theEmployee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {

        Optional<Employee> tempEmployee = employeeService.findById(employeeId);
        employeeService.deleteById(employeeId);
        return "Deleted employee id - " + employeeId;
    }


}
