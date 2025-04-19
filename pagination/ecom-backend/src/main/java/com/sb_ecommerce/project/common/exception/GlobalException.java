package com.sb_ecommerce.project.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalException {
    @ExceptionHandler(IDNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleIDNotFoundException(IDNotFoundException ex, WebRequest webRequest) {
        ErrorDetails errorDetails = new ErrorDetails(
                ex.getMessage(),
                LocalDateTime.now(),
                webRequest.getDescription(false),
                "ID_NOT_FOUND"
        );
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleException(Exception e, WebRequest webRequest) {
        ErrorDetails errorDetails = new ErrorDetails(
                e.getMessage(),
                LocalDateTime.now(),
                webRequest.getDescription(false),
                "Internal Server Error"
        );
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
