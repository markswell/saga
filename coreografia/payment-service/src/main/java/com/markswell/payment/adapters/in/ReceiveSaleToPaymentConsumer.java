package com.markswell.payment.adapters.in;

import com.markswell.payment.adapters.out.message.SaleMessage;
import com.markswell.payment.application.core.domain.enums.SaleEvent;
import com.markswell.payment.application.ports.in.SalePaymentInputPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import static com.markswell.payment.application.core.domain.enums.SaleEvent.UPDATED_INVENTORY;

@Slf4j
@Component
@RequiredArgsConstructor
public class ReceiveSaleToPaymentConsumer {

    private final SalePaymentInputPort salePaymentInputPort;

    @KafkaListener(topics = "tp-saga-sale", groupId = "payment")
    public void receive(SaleMessage saleMessage) {
        if(UPDATED_INVENTORY.equals(saleMessage.getEvent())) {
            log.info("Payment start");
            salePaymentInputPort.payment(saleMessage.getSale());
            log.info("Payment finished");
        }
    }

}
