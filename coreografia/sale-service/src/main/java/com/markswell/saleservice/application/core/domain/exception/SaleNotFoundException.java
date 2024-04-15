package com.markswell.saleservice.application.core.domain.exception;

public class SaleNotFoundException extends RuntimeException {

    public SaleNotFoundException(Integer id) {
        super("Sale %d was not found".formatted(id));
    }

}
