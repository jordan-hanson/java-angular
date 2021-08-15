package com.observepoint.test.test.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message)
    {
        super("Error from Test ObservePoint " + message);
    }
}
