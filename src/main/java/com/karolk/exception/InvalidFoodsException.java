package com.karolk.exception;

public class InvalidFoodsException extends RuntimeException {
    public InvalidFoodsException(String message) {
        super(message);
    }
}
