package com.example.finalproj02.exceptions;

public class PlayerNotFoundException extends  Exception{
    public PlayerNotFoundException() {
        super(" - Invalid password format exception");
    }

    public PlayerNotFoundException(String subMessage) {
        super(subMessage);
    }

    public PlayerNotFoundException(String superMessage, String subMessage) {
        super(superMessage + " - " + subMessage);
    }
}