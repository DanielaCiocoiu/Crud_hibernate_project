package com.personalProject.Enterprise_employees_management_system.error;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhoneErrorResponse {

    private int status;
    private String message;
    private long timestamp;

}
