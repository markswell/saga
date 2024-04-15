package com.markswell.saleservice.adapter.out;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.kafka.core.KafkaTemplate;
import com.markswell.saleservice.application.core.domain.Sale;
import com.markswell.saleservice.adapter.out.message.SaleMessage;
import com.markswell.saleservice.application.core.domain.enums.SaleEvent;
import com.markswell.saleservice.application.port.out.SendCreatedSaleOutputPort;

@Component
@RequiredArgsConstructor
public class SendCreatedSaleAdapter implements SendCreatedSaleOutputPort {

    private final KafkaTemplate<String, SaleMessage> kafkaTemplate;

    @Override
    public void send(Sale sale, SaleEvent saleEvent) {
        var saleMessage = new SaleMessage(sale, saleEvent);
        kafkaTemplate.send("tp-saga-orchestrator", saleMessage);
    }
}
