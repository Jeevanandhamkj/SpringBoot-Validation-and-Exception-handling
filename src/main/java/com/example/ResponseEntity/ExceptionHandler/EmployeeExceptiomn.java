package com.example.ResponseEntity.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class EmployeeExceptiomn {
@ExceptionHandler(TransactionSystemException.class)
    public Map<String,String> fun(TransactionSystemException e){
    Map<String,String>errorMap=new HashMap<>();
    errorMap.put("error","TransactionSystemException");
    errorMap.put("Message","Check your input field");
    return errorMap;

    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String>kj(MethodArgumentNotValidException k){
    Map<String,String>error=new HashMap<>();
    error.put("error","MethodArgumentNotValidException");
    error.put("message","check your input");
    return error;
    }
    @ExceptionHandler(NoSuchElementException.class)
    public Map<String,String>kk(NoSuchElementException e){
    Map<String,String>err=new HashMap<>();
    err.put("error","NoSuchElementException");
    err.put("message","usernotFound create new");
    return err;
    }
}
