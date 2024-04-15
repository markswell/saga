package com.markswell.payment.application.core.usecase.exception;

public class InsufficientFunds extends RuntimeException {

    public InsufficientFunds(String message) {
        super(message);
    }
}
