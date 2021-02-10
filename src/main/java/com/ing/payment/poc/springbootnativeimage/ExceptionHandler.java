package com.ing.payment.poc.springbootnativeimage;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler({CustomerNotFoundException.class})
    public ResponseEntity handleCustomerNotFoundException(CustomerNotFoundException exception) {
        return ResponseEntity.notFound().build();
    }
}
