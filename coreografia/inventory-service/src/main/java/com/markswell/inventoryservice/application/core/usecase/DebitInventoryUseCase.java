package com.markswell.inventoryservice.application.core.usecase;

import com.markswell.inventoryservice.application.core.domain.Sale;
import com.markswell.inventoryservice.application.ports.in.DebitInventoryInputPort;
import com.markswell.inventoryservice.application.ports.out.UpdateInventoryOutputPort;
import com.markswell.inventoryservice.application.ports.out.SendToKafkaInventoryOutputPort;
import com.markswell.inventoryservice.application.ports.in.FindInventoryByProductIdInputPort;
import com.markswell.inventoryservice.application.core.domain.exception.InsufficientProductQuantityException;

import static com.markswell.inventoryservice.application.core.domain.enums.SaleEvent.ROLLBACK_INVENTORY;
import static com.markswell.inventoryservice.application.core.domain.enums.SaleEvent.UPDATED_INVENTORY;

public class DebitInventoryUseCase implements DebitInventoryInputPort {

    private final UpdateInventoryOutputPort updateInventoryOutputPort;

    private final FindInventoryByProductIdInputPort findInventoryByProductIdInputPort;

    private final SendToKafkaInventoryOutputPort sendToKafkaInventoryOutputPort;

    public DebitInventoryUseCase(FindInventoryByProductIdInputPort findInventoryByProductIdInputPort,
                                 UpdateInventoryOutputPort updateInventoryOutputPort,
                                 SendToKafkaInventoryOutputPort sendToKafkaInventoryOutputPort) {
        this.updateInventoryOutputPort = updateInventoryOutputPort;
        this.findInventoryByProductIdInputPort = findInventoryByProductIdInputPort;
        this.sendToKafkaInventoryOutputPort = sendToKafkaInventoryOutputPort;
    }

    @Override
    public void debit(Sale sale) {
        try {
            var inventory = findInventoryByProductIdInputPort.find(sale.getProductId());
            if(inventory.getQuantity() < sale.getQuantity()) {
                throw new InsufficientProductQuantityException("There is just %s of product %s".formatted(inventory.getQuantity(), sale.getProductId()));
            }
            inventory.debitQuantity(sale.getQuantity());
            updateInventoryOutputPort.update(inventory);
            sendToKafkaInventoryOutputPort.send(sale, UPDATED_INVENTORY);
        } catch (InsufficientProductQuantityException e) {
            sendToKafkaInventoryOutputPort.send(sale, ROLLBACK_INVENTORY);
            throw e;
        }

    }

}
