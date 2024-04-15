package com.markswell.inventoryservice.application.core.domain.exception;

public class InventoryNotFound extends RuntimeException{

    public InventoryNotFound(String message) {
        super(message);
    }
}
