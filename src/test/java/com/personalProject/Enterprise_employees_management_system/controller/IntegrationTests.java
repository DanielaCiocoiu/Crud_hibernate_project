package com.personalProject.Enterprise_employees_management_system.controller;

import com.personalProject.Enterprise_employees_management_system.entity.Departament;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getEmployeeByCategory() throws Exception{
        this.mockMvc.perform(
                get("/api/{name}", Departament.HR))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(4))
                .andExpect(jsonPath("$.[*].firstName").value(containsInAnyOrder("Yuri", "Jack", "Maia", "Irinel")))
                .andExpect(jsonPath("$.[0].firstName").value("Yuri"))
                .andExpect(jsonPath("$.[1].firstName").value("Jack"));

    }
    //FIXME
}
