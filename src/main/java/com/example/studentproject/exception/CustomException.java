package com.example.studentproject.exception;

public class CustomException extends RuntimeException {
    public String message;
    public CustomException(String message) {
        super(message);
    }
}
