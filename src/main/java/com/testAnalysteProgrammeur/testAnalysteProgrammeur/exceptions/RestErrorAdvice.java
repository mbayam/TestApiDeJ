package com.testAnalysteProgrammeur.testAnalysteProgrammeur.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
public class RestErrorAdvice {

    @ExceptionHandler({FilmNotFoundException.class})
    public ResponseEntity<Object> handleNoHandlerFoundException(FilmNotFoundException e) {
        return error(NOT_FOUND, e.getMessage());
    }

    private ResponseEntity<Object> error(HttpStatus status, Object apiError) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Content-Type", "application/json");
        return ResponseEntity.status(status).headers(responseHeaders).body(apiError);
    }
}
