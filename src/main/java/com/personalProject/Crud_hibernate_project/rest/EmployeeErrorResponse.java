package com.personalProject.Crud_hibernate_project.rest;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeErrorResponse {

    private int status;
    private String message;
    private long timestamp;

}
