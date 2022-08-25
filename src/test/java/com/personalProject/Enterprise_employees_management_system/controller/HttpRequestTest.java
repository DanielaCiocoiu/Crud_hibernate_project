package com.personalProject.Enterprise_employees_management_system.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {

    private static final Logger logger
            = LoggerFactory.getLogger(HttpRequestTest.class);

    private static final String get_Employee_By_id_URL = "http://localhost:8080/api/employees/";

    RestTemplate restTemplate = new RestTemplate();

    @Test
    public void getEmployeeByIdTestRestTemplate() {


        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
        restTemplateBuilder.configure(restTemplate);

//TestRestTemplate can be considered an alternative of RestTemplate,
// handle communicating with HTTP API, work as a wrapper for RestTemplate
        TestRestTemplate testRestTemplate = new TestRestTemplate(restTemplateBuilder);

        ResponseEntity<String> response = testRestTemplate.getForEntity(
                get_Employee_By_id_URL + 4, String.class);
        ResponseEntity<String> response1 = testRestTemplate.getForEntity(
                get_Employee_By_id_URL + "4}", String.class);
        ResponseEntity<String> response2 = testRestTemplate.getForEntity(
                get_Employee_By_id_URL + 15, String.class);

        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
        Assertions.assertEquals(response1.getStatusCode(), HttpStatus.BAD_REQUEST);
        Assertions.assertEquals(response2.getStatusCode(), HttpStatus.NOT_FOUND);

    }

/*    @Test
    public void secureAuthTestRestTemplate() {

        TestRestTemplate testRestTemplate
                = new TestRestTemplate("user", "passwd");
        ResponseEntity<String> response = testRestTemplate.
                getForEntity(URL_SECURED_BY_AUTHENTICATION, String.class);

        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);

    }*/
}