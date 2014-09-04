package com.hp.manner.exception;

public class UserExistsException extends Exception {

	private static final long serialVersionUID = -2590314424204485720L;

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

}
