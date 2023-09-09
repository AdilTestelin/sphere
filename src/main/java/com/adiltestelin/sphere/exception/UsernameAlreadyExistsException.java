package com.adiltestelin.sphere.exception;

public class UsernameAlreadyExistsException extends RuntimeException {
    public UsernameAlreadyExistsException(final String message) {
        super(message);
    }
}
