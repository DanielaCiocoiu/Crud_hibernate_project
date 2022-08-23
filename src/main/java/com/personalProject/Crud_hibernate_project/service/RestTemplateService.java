package com.personalProject.Crud_hibernate_project.service;

import com.personalProject.Crud_hibernate_project.entity.Employee;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Service
public class RestTemplateService {

    RestTemplate restTemplate = new RestTemplate();

    private static final String get_All_Employee_URL = "http://localhost:8080/api/employees";
    private static final String create_All_Employee_URL = "http://localhost:8080/api/employees";
    private static final String get_Employee_By_id_URL = "http://localhost:8080/api/employees/{id}";


    public ResponseEntity<String> allEmployee() {

        HttpHeaders headers = new HttpHeaders();

        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        // headers.add("Authorization", headerValue);

        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);

        ResponseEntity<String> response = restTemplate.exchange(get_All_Employee_URL, HttpMethod.GET, entity, String.class);

        return response;
    }

    public ResponseEntity<Employee> createEmployee(Employee employee) {
        return restTemplate.postForEntity(create_All_Employee_URL, employee, Employee.class);
    }

    public Employee getEmployeeById(int id) {
        Map<String, Integer> param = new HashMap<>();
        param.put("id", id);
        return restTemplate.getForObject(get_Employee_By_id_URL, Employee.class, param);

    }
}
