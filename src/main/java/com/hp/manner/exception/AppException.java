package com.hp.manner.exception;

public class AppException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private String errMsg;

    public AppException() {
        super();
    }

    public AppException(String errMsg) {
        super(errMsg);
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

}
