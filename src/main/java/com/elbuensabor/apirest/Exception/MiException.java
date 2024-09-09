package com.elbuensabor.apirest.Exception;

public class MiException extends RuntimeException{

    public MiException(String message) {
        super(message);
    }

    public MiException(String message, Throwable cause) {
        super(message, cause);
    }
}
