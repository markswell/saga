package com.markswell.inventoryservice.application.core.domain.exception;

public class InsufficientProductQuantityException extends RuntimeException{

    public InsufficientProductQuantityException(String message) {
        super(message);
    }
}
