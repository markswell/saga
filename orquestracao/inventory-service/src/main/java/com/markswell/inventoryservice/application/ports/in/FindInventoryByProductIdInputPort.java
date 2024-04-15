package com.markswell.inventoryservice.application.ports.in;

import com.markswell.inventoryservice.application.core.domain.Inventory;

public interface FindInventoryByProductIdInputPort {

    Inventory find(Integer productId);

}
