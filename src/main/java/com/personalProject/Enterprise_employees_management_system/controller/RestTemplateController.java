package com.personalProject.Enterprise_employees_management_system.controller;

import com.personalProject.Enterprise_employees_management_system.domain.Employee;
import com.personalProject.Enterprise_employees_management_system.service.RestTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/RestTemplate")
public class RestTemplateController {

    @Autowired
    private RestTemplateService restTemplateService;

    //   -  http://localhost:8080/RestTemplate/getAllEmployee
    @GetMapping("/getAllEmployee")
    public ResponseEntity<String> getAllEmployee() {
       return restTemplateService.allEmployee();
    }

    //   -  http://localhost:8080/RestTemplate/addEmployee
    @PostMapping("/addEmployee")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        return restTemplateService.createEmployee(employee);
    }

    //FIXME

    //   -  http://localhost:8080/RestTemplate/getEmployeeById/4
    @GetMapping("/getEmployeeById/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        return restTemplateService.updateEmployeeById(id);
    }

    @GetMapping("/deleteEmployeeById/{id}")
    public Employee deleteEmployeeById(@PathVariable int id) {
        return restTemplateService.deleteEmployeeById(id);
    }
}
