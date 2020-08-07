package com.karolk.exception;

public class InvalidFoodProductException extends RuntimeException {
    public InvalidFoodProductException(String message){
        super(message);
    }
}
