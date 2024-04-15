package com.markswell.orchestrator.adapter.out;

import com.markswell.orchestrator.adapter.out.message.SaleMessage;
import com.markswell.orchestrator.application.core.domain.Sale;
import com.markswell.orchestrator.application.core.domain.enums.SaleEvent;
import com.markswell.orchestrator.application.ports.out.SendSaleToTopicOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SendSaleToTopicAdapter implements SendSaleToTopicOutputPort {

    private final KafkaTemplate<String, SaleMessage> kafkaTemplate;

    @Override
    public void send(Sale sale, SaleEvent saleEvent, String topic) {
        var saleMessage = new SaleMessage(sale, saleEvent);
        kafkaTemplate.send(topic, saleMessage);
    }
}
