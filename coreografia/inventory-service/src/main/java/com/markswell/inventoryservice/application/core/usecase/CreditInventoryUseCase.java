package com.markswell.inventoryservice.application.core.usecase;

import com.markswell.inventoryservice.application.core.domain.Sale;
import com.markswell.inventoryservice.application.ports.in.CreditInventoryInputPort;
import com.markswell.inventoryservice.application.ports.out.UpdateInventoryOutputPort;
import com.markswell.inventoryservice.application.ports.out.SendToKafkaInventoryOutputPort;
import com.markswell.inventoryservice.application.ports.in.FindInventoryByProductIdInputPort;

import static com.markswell.inventoryservice.application.core.domain.enums.SaleEvent.ROLLBACK_INVENTORY;

public class CreditInventoryUseCase implements CreditInventoryInputPort {

    private final UpdateInventoryOutputPort updateInventoryOutputPort;
    private final SendToKafkaInventoryOutputPort sendToKafkaInventoryOutputPort;
    private final FindInventoryByProductIdInputPort findInventoryByProductIdInputPort;


    public CreditInventoryUseCase(
            UpdateInventoryOutputPort updateInventoryOutputPort,
            SendToKafkaInventoryOutputPort sendToKafkaInventoryOutputPort,
            FindInventoryByProductIdInputPort findInventoryByProductIdInputPort
            ) {
        this.updateInventoryOutputPort = updateInventoryOutputPort;
        this.sendToKafkaInventoryOutputPort = sendToKafkaInventoryOutputPort;
        this.findInventoryByProductIdInputPort = findInventoryByProductIdInputPort;
    }

    @Override
    public void credit(Sale sale) {
        var inventory = findInventoryByProductIdInputPort.find(sale.getProductId());
        inventory.creditQuantity(sale.getQuantity());
        updateInventoryOutputPort.update(inventory);
        sendToKafkaInventoryOutputPort.send(sale, ROLLBACK_INVENTORY);
    }

}
