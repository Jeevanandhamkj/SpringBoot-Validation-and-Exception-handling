package com.example.ResponseEntity.Controller;

public class UserAlreadyExsitsException extends RuntimeException{
    public UserAlreadyExsitsException (String s){
super(s);
    }
}
