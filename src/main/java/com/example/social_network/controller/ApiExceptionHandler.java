package com.example.social_network.controller;

import com.example.social_network.exceptions.ApiException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author Дмитрий Карпушов 31.07.2023
 */

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<Object> handleApiException(ApiException e){
        return new ResponseEntity<>(e, e.getStatus());
    }
}
