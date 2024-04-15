package com.markswell.inventoryservice.application.ports.in;

import com.markswell.inventoryservice.application.core.domain.Sale;

public interface CreditInventoryInputPort {
    void credit(Sale sale);
}
