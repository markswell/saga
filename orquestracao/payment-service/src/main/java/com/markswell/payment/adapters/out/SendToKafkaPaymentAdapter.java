package com.markswell.payment.adapters.out;

import com.markswell.payment.adapters.out.message.SaleMessage;
import com.markswell.payment.application.core.domain.Sale;
import com.markswell.payment.application.core.domain.enums.SaleEvent;
import com.markswell.payment.application.ports.out.SendToKafkaPaymentOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SendToKafkaPaymentAdapter implements SendToKafkaPaymentOutputPort {

    private final KafkaTemplate<String, SaleMessage> kafkaTemplate;

    @Override
    public void send(Sale sale, SaleEvent saleEvent) {
        SaleMessage saleMessage = new SaleMessage(sale, saleEvent);
        kafkaTemplate.send("tp-saga-orchestrator", saleMessage);
    }
}
