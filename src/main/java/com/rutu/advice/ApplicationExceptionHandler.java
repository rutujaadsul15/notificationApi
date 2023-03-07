package com.rutu.advice;


import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApplicationExceptionHandler {


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleException(MethodArgumentNotValidException ex) {
        Map<String, String> resultMap = new HashMap<>();
        ex.getFieldErrors().forEach(fieldError -> {
            resultMap.put(fieldError.getField(), fieldError.getDefaultMessage());
        });
        return resultMap;
    }
}
