package com.hp.manner.exception;

public class AppException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private String message;

    public AppException() {
        super();
    }

    public AppException(String message) {
        super(message);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
