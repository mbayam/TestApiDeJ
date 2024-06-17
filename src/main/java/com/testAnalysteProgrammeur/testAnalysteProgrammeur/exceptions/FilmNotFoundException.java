package com.testAnalysteProgrammeur.testAnalysteProgrammeur.exceptions;

//@ResponseStatus(code=HttpStatus.NOT_FOUND)
public class FilmNotFoundException extends RuntimeException {
    public FilmNotFoundException(String message) {
        super(message);
    }
}
