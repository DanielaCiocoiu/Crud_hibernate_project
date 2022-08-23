package com.personalProject.Crud_hibernate_project.rest;

import com.personalProject.Crud_hibernate_project.entity.Employee;
import com.personalProject.Crud_hibernate_project.service.RestTemplateService;
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

    //   -  http://localhost:8080/RestTemplate/getEmployeeById/4
    @GetMapping("/getEmployeeById/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        return restTemplateService.getEmployeeById(id);
    }
}
