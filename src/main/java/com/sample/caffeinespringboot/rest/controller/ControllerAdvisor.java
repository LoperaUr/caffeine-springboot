package com.sample.caffeinespringboot.rest.controller;

import com.sample.caffeinespringboot.exception.GenericException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collections;
import java.util.Map;

@ControllerAdvice
public class ControllerAdvisor {

    public static final String MESSAGE = "message";

    @ExceptionHandler(GenericException.class)
    public ResponseEntity<Map<String, String>> handleGenericException(GenericException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Collections.singletonMap(MESSAGE, e.getMessage()));
    }

}
