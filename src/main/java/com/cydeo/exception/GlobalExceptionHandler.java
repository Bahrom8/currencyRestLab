package com.cydeo.exception;

import com.cydeo.dto.ResponseWrapper;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ExceptionWrapper> userNotFoundException(UserNotFoundException exception, HttpServletRequest request){

        exception.printStackTrace();
        String message = exception.getMessage();

        ExceptionWrapper exceptionWrapper = new ExceptionWrapper(HttpStatus.NOT_FOUND.value(), message, request.getRequestURI());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionWrapper);

    }


}
