package com.demo.first.app.exceptions;

import com.demo.first.app.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice//global exception handler and it intersapt the exception and it handle thow exception
public class GlobalExceptionHandler {
    private final Logger logger= LoggerFactory.getLogger(GlobalExceptionHandler.class);
    // EXCEPTION HANDLING METHOD
    @ExceptionHandler({ UserNotFoundException.class,IllegalArgumentException.class, NullPointerException.class})
    public ResponseEntity<Map<String, Object>> handleIllegalArgumentException(
            Exception exception) {

        logger.error("Error when finding user :",exception);
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("timestamp ", LocalDateTime.now());
        errorResponse.put("message ", exception.getMessage());
        errorResponse.put("state ", HttpStatus.BAD_REQUEST.value());
        errorResponse.put("error ", "Bad gfdgfd request");

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<Map<String, Object>> haldleMethodNotSupported(
            Exception exception) {

        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("timestamp ", LocalDateTime.now());
        errorResponse.put("message ", exception.getMessage());
        errorResponse.put("state ", HttpStatus.METHOD_NOT_ALLOWED.value());
        errorResponse.put("error ", "Method not allowed on this endpoint");

        return new ResponseEntity<>(errorResponse, HttpStatus.METHOD_NOT_ALLOWED);
    }
}