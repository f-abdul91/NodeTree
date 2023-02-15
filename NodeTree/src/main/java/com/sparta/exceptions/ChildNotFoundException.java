package com.sparta.exceptions;

public class ChildNotFoundException extends Exception {

    public ChildNotFoundException(){}

    public ChildNotFoundException(String message){
        super(message);
    }
}
