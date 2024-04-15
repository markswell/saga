package com.markswell.inventoryservice.adapter.in.consumer;

import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.kafka.annotation.KafkaListener;
import com.markswell.inventoryservice.adapter.out.message.SaleMessage;
import com.markswell.inventoryservice.application.ports.in.CreditInventoryInputPort;

import static com.markswell.inventoryservice.application.core.domain.enums.SaleEvent.EXECUTE_ROLLBACK;

@Slf4j
@Component
@RequiredArgsConstructor
public class ReceiveSaleToCreditInventoryConsumer {

    private final CreditInventoryInputPort creditInventoryInputPort;

    @KafkaListener(topics = "tp-saga-inventory", groupId = "inventory-credit")
    public void receive(SaleMessage saleMessage) {
        if(EXECUTE_ROLLBACK.equals(saleMessage.getEvent())) {
            log.info("Rollback inventory start");
            creditInventoryInputPort.credit(saleMessage.getSale());
            log.info("Rollback inventory finish");
        }
    }

}
