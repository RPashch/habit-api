package com.lyceum.habitapi.exceptions;

public class CategoryNotFoundException extends RuntimeException{

    public CategoryNotFoundException(String text) {
        super(text);
    }
}
