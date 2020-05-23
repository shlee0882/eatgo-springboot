package com.example.eatgo.application;

public class PasswordWrongException extends RuntimeException{
    PasswordWrongException(){
        super("Password is wrong");
    }
}
