package com.bootcamp_santander_2025.controller.exception;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleBusinesException(IllegalArgumentException businessException) {
        return new ResponseEntity<>(businessException.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
    }
}

@ExceptionHandler(NoSuchElementException.class)
public ResponseEntity<String> handleNotFoundException(NoSuchElementException businessException) {
    return new ResponseEntity<>("Resource ID not found", HttpStatus.NOT_FOUND);
}


@ExceptionHandler(Throwable.class)
public ResponseEntity<String> handleNotFoundException(Throwable underexpectedExeption) {
    var message = "Unexpected server error. see the logs";
    Logger.error(message, underexpectedExeption);
    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
}
