package ru.nsu.manager.controller.advice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.nsu.manager.exception.RequestNotFoundException;

@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(RequestNotFoundException.class)
    public ResponseEntity<Void> authExceptionHandler(RequestNotFoundException exception) {
        return ResponseEntity.notFound().build();
    }
}
