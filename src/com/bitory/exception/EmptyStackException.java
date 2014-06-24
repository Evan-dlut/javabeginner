package com.bitory.exception;

/**
 * Created by bitory on 2014/6/22.
 */
public class EmptyStackException extends RuntimeException{

    private static final long serialVersionUID = -4864888018824479639L;

    public EmptyStackException() {
        super();
    }

    public EmptyStackException(String message) {
        super(message);
    }

    public EmptyStackException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmptyStackException(Throwable cause) {
        super(cause);
    }
}
