package com.personalProject.Enterprise_employees_management_system.rest;


import com.personalProject.Enterprise_employees_management_system.entity.Departament;
import com.personalProject.Enterprise_employees_management_system.entity.Employee;
import com.personalProject.Enterprise_employees_management_system.service.EmployeeService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    @Cacheable(value = "cacheStudent")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {
        Employee theEmployee = employeeService.findById(employeeId);
        if ((theEmployee == null) || (employeeId < 0)) {
            throw new EmplyeeNotFoundException("Employee id not found - " + employeeId);
        }
        return theEmployee;
    }

    //http://localhost:8080/api?departament=HR
    @GetMapping
    public List<Employee> getEmployeeDepartamentWithRequestParam(@RequestParam(value="departament") Departament departament)  {

        return employeeService.getEmployeeByDepartament(departament);
    }

    @GetMapping("/{name}")
    public List<Employee> getEmployeeDepartament(@PathVariable(name = "name") Departament departament) {
        return employeeService.getEmployeeByDepartament(departament);
    }

    @PostMapping("/employees")
    @ResponseStatus(HttpStatus.CREATED)
    public Employee addEmployee(@RequestBody Employee theEmployee) {
        theEmployee.setId(0);
        employeeService.save(theEmployee);
        return theEmployee;
    }

    @PutMapping("/employees")
    @ResponseStatus(HttpStatus.OK)
    public Employee updateEmployee(@RequestBody Employee theEmployee) {
        employeeService.save(theEmployee);
        return theEmployee;
    }

    @DeleteMapping("/employees/{employeeId}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteEmployee(@PathVariable int employeeId) {

        Employee tempEmployee = employeeService.findById(employeeId);
        employeeService.deleteById(employeeId);
        return "Deleted employee id - " + employeeId;
    }

}
