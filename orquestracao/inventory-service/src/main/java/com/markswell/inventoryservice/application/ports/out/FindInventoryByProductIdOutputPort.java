package com.markswell.inventoryservice.application.ports.out;

import com.markswell.inventoryservice.application.core.domain.Inventory;

import java.util.Optional;

public interface FindInventoryByProductIdOutputPort {

    Optional<Inventory> find(Integer productId);

}
