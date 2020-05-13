package com.spardarus.controller.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestControllerAdvice
@Slf4j
public class RestControllerExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidException(MethodArgumentNotValidException exception) {
        List<ObjectError> objectErrors = exception.getBindingResult().getAllErrors();

        List<String> responseErrors = new ArrayList<>();
        objectErrors.forEach(objectError -> responseErrors.add(objectError.getDefaultMessage()));

        return new ResponseEntity<>(responseErrors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<?> handleCredentialException(BadCredentialsException exception) {
        String message = "Wrong email or password";
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception exception) {
        String errorId = UUID.randomUUID().toString();
        String message = "Please contact with administrator with error id: " + errorId;
        log.error("Error id: {}, cause: ", errorId, exception);
        return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
