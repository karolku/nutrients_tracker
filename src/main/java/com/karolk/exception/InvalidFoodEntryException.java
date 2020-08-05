package com.karolk.exception;

public class InvalidFoodEntryException extends RuntimeException {
    public InvalidFoodEntryException(String message){
        super(message);
    }
}
