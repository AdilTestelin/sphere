package com.adiltestelin.sphere.exception;

public class MailAlreadyExistsException extends RuntimeException {

    public MailAlreadyExistsException(final String message) {
        super(message);
    }
}
