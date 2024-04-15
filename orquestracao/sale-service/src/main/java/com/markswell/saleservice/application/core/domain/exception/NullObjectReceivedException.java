package com.markswell.saleservice.application.core.domain.exception;

public class NullObjectReceivedException extends RuntimeException {

    public NullObjectReceivedException(String message) {
        super(message);
    }
}
