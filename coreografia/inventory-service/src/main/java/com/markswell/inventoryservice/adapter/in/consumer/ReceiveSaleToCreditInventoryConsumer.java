package com.markswell.inventoryservice.adapter.in.consumer;

import com.markswell.inventoryservice.adapter.out.message.SaleMessage;
import com.markswell.inventoryservice.application.core.domain.enums.SaleEvent;
import com.markswell.inventoryservice.application.ports.in.CreditInventoryInputPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import static com.markswell.inventoryservice.application.core.domain.enums.SaleEvent.FAILED_PAYMENT;

@Slf4j
@Component
@RequiredArgsConstructor
public class ReceiveSaleToCreditInventoryConsumer {

    private final CreditInventoryInputPort creditInventoryInputPort;

    @KafkaListener(topics = "tp-saga-sale", groupId = "inventory-credit")
    public void receive(SaleMessage saleMessage) {
        if(FAILED_PAYMENT.equals(saleMessage.getEvent())) {
            log.info("Rollback inventory start");
            creditInventoryInputPort.credit(saleMessage.getSale());
            log.info("Rollback inventory finish");
        }
    }

}
