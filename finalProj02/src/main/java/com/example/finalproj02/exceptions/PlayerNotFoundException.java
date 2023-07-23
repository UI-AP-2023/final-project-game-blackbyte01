package com.example.finalproj02.exceptions;

public class PlayerNotFoundException extends Exception {
    public PlayerNotFoundException() {
        super("player not found");
    }

    public PlayerNotFoundException(String message) {
        super(message);
    }
}