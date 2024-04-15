package com.markswell.inventoryservice.adapter.in.consumer;

import com.markswell.inventoryservice.application.ports.in.DebitInventoryInputPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.kafka.annotation.KafkaListener;
import com.markswell.inventoryservice.adapter.out.message.SaleMessage;

import static com.markswell.inventoryservice.application.core.domain.enums.SaleEvent.PREPARE_INVENTORY;

@Slf4j
@Component
@RequiredArgsConstructor
public class ReceiveSaleToDebitInventoryConsumer {

    private final DebitInventoryInputPort debitInventoryInputPort;

    @KafkaListener(topics = "tp-saga-inventory", groupId = "inventory-debit")
    public void receive(SaleMessage saleMessage) {
        if(PREPARE_INVENTORY.equals(saleMessage.getEvent())) {
            log.info("Separate product starts");
            debitInventoryInputPort.debit(saleMessage.getSale());
            log.info("Separate product finish");
        }
    }

}
