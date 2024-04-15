package com.markswell.inventoryservice.application.ports.out;

import com.markswell.inventoryservice.application.core.domain.Inventory;

public interface UpdateInventoryOutputPort {

    void update(Inventory inventory);

}
