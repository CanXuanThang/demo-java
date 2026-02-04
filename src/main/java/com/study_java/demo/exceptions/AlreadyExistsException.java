package com.study_java.demo.exceptions;

public class AlreadyExistsException extends  RuntimeException{
    public AlreadyExistsException(String message){
        super(message);
    }
}
