package com.lyceum.habitapi.exceptions;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String text) {
        super(text);
    }
}
