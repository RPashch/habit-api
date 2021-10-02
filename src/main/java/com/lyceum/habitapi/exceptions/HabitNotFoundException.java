package com.lyceum.habitapi.exceptions;

public class HabitNotFoundException extends RuntimeException {

    public HabitNotFoundException(String text) {
       super(text);
    }
}
