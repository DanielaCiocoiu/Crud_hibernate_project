package com.personalProject.Enterprise_employees_management_system.entity;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeErrorResponse {

    private int status;
    private String message;
    private long timestamp;

}
