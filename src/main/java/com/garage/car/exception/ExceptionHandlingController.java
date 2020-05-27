package com.garage.car.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class ExceptionHandlingController {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> error(Exception ex) {
        ErrorDetails response = new ErrorDetails(new Date(), "Internal Error ", ex.getMessage());

        return new ResponseEntity<ErrorDetails>(response, HttpStatus.SERVICE_UNAVAILABLE);
    }
}