package com.example.finalproj02.exceptions;

public class NoCreatedMapException extends Exception{
    public NoCreatedMapException() {
        super(" - Invalid password format exception");
    }

    public NoCreatedMapException(String subMessage) {
        super(subMessage);
    }

    public NoCreatedMapException(String superMessage, String subMessage) {
        super(superMessage + " - " + subMessage);
    }
}
