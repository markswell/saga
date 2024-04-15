package com.markswell.inventoryservice.application.core.usecase;

import com.markswell.inventoryservice.application.core.domain.Inventory;
import com.markswell.inventoryservice.application.core.domain.exception.InventoryNotFound;
import com.markswell.inventoryservice.application.ports.in.FindInventoryByProductIdInputPort;
import com.markswell.inventoryservice.application.ports.out.FindInventoryByProductIdOutputPort;

public class FindInventoryByProductIdUseCase implements FindInventoryByProductIdInputPort {

    private final FindInventoryByProductIdOutputPort findInventoryByProductIdOutputPort;

    public FindInventoryByProductIdUseCase(FindInventoryByProductIdOutputPort findInventoryByProductIdOutputPort) {
        this.findInventoryByProductIdOutputPort = findInventoryByProductIdOutputPort;
    }

    @Override
    public Inventory find(Integer productId) {
        return findInventoryByProductIdOutputPort.find(productId)
                .orElseThrow(() -> new InventoryNotFound("It wasn't found inventory with id: %s".formatted(productId)));
    }

}
