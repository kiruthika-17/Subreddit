package com.onedirect.reddit.exception;

public class DataNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public DataNotFoundException(String msg) {
        super(msg);
    }
    public DataNotFoundException() {
        super();
    }
    public DataNotFoundException(Throwable cause) {
        super(cause);
    }
}
