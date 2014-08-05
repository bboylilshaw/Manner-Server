package com.hp.manner.exception;

public class UserExistsException extends Exception {

    private String message;

    public UserExistsException() {
        super();
    }

    public UserExistsException(String message) {
        super(message);
        this.message=message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
