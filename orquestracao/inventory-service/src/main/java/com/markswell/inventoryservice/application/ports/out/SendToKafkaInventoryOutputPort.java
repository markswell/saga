package com.markswell.inventoryservice.application.ports.out;

import com.markswell.inventoryservice.application.core.domain.Sale;
import com.markswell.inventoryservice.application.core.domain.enums.SaleEvent;

public interface SendToKafkaInventoryOutputPort {

    void send(Sale sale, SaleEvent saleEvent);

}
