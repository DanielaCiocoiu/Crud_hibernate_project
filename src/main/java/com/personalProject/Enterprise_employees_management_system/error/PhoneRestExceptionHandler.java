package com.personalProject.Enterprise_employees_management_system.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PhoneRestExceptionHandler {


    @ExceptionHandler
    public ResponseEntity<PhoneErrorResponse> handleException(PhoneNotFoundException exc) {
        PhoneErrorResponse errorResponse = new PhoneErrorResponse();
        errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        errorResponse.setMessage(exc.getMessage());
        errorResponse.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    //handler de exceptie generic, pt orice tip de ex
    @ExceptionHandler
    public ResponseEntity<PhoneErrorResponse> handleException(Exception exc) {

        PhoneErrorResponse errorResponse = new PhoneErrorResponse();

        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        errorResponse.setMessage(exc.getMessage());
        errorResponse.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
