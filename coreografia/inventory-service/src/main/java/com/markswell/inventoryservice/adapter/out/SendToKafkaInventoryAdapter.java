package com.markswell.inventoryservice.adapter.out;

import com.markswell.inventoryservice.adapter.out.message.SaleMessage;
import com.markswell.inventoryservice.application.core.domain.Sale;
import com.markswell.inventoryservice.application.core.domain.enums.SaleEvent;
import com.markswell.inventoryservice.application.ports.out.SendToKafkaInventoryOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SendToKafkaInventoryAdapter implements SendToKafkaInventoryOutputPort {

    private final KafkaTemplate<String, SaleMessage> kafkaTemplate;

    @Override
    public void send(Sale sale, SaleEvent saleEvent) {
        var saleMessage = new SaleMessage(sale, saleEvent);
        kafkaTemplate.send("tp-saga-sale", saleMessage);
    }
}
