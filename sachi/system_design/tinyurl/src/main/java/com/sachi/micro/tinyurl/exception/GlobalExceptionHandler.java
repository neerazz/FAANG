package com.sachi.micro.tinyurl.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), request.getDescription(false), ex.getMessage(), null);
        log.error("Resource Not Found Exception exception. Error message - {}  - Stack Trace - {}", ex.getMessage(), ex.getStackTrace());
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(HttpClientErrorException.BadRequest.class)
    public ResponseEntity<?> badData(ResourceNotFoundException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), request.getDescription(false), ex.getMessage(), null);
        log.error("Bad exception. Error message - {}  - Stack Trace - {}", ex.getMessage(), ex.getStackTrace());
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> globalExceptionHandler(Exception ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), request.getDescription(false), ex.getMessage(), null);
        log.error("Generic exception. Error message - {} - Stack Trace - {}", ex.getMessage(), ex.getStackTrace());
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public final ResponseEntity<ErrorDetails> handleConstraintViolation(
            ConstraintViolationException ex,
            WebRequest request) {
        List<String> messages = ex.getConstraintViolations()
                .parallelStream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.toList());

        ErrorDetails error = new ErrorDetails(new Date(), request.getDescription(false), null, messages);
        log.error("Constraint violation exception. Error message - {}. Constraint Violations - {} - Stack Trace - {} ", ex.getMessage(), messages, ex.getStackTrace());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}
