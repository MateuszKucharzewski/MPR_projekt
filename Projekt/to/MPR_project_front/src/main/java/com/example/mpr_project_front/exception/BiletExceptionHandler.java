package com.example.mpr_project_front.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class BiletExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {BiletNotFoundException.class})
    public ResponseEntity<Object> handleNotFound(RuntimeException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {BiletExist.class})
    public ResponseEntity<Object> handleExist(RuntimeException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }
}

