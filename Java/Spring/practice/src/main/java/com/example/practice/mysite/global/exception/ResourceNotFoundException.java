package com.example.practice.mysite.global.exception;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException() {
        super("리소스를 찾을 수 없습니다.");
    }
}
