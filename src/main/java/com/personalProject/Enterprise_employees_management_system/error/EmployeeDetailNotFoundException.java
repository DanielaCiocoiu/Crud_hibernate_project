package com.personalProject.Enterprise_employees_management_system.error;

public class EmployeeDetailNotFoundException extends RuntimeException {
    public EmployeeDetailNotFoundException(String message) {
        super(message);
    }

    public EmployeeDetailNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmployeeDetailNotFoundException(Throwable cause) {
        super(cause);
    }


}
