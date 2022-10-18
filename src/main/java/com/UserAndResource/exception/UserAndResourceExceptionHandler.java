package com.UserAndResource.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
    public class UserAndResourceExceptionHandler {
        @ExceptionHandler
        public ResponseEntity handleUserNotFoundException(UserNotFoundException userNotFoundException) {
            return new ResponseEntity("{}", HttpStatus.NOT_FOUND);
        }
        @ExceptionHandler
        public ResponseEntity handleBookNotFoundException(ResourceNotFoundException resourceNotFoundException) {
            return new ResponseEntity("{}", HttpStatus.NOT_FOUND);
        }
    }

