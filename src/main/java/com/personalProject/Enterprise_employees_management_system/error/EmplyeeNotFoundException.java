package com.personalProject.Enterprise_employees_management_system.error;

public class EmplyeeNotFoundException extends RuntimeException {
    public EmplyeeNotFoundException(String message) {
        super(message);
    }

    public EmplyeeNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmplyeeNotFoundException(Throwable cause) {
        super(cause);
    }


}
