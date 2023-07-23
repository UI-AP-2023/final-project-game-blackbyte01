package com.example.finalproj02.exceptions;

public class InvalidPasswordException extends Exception {
    public InvalidPasswordException() {
        super("invalid password");
    }

    public InvalidPasswordException(String message) {
        super(message);
    }
}
