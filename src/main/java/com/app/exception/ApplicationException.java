package com.app.exception;

/**
 * Custom exception class.
 */
public class ApplicationException extends RuntimeException {

    public ApplicationException() {
    }

    public ApplicationException(String message) {
        super(message);
    }
}
