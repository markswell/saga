package com.markswell.payment.adapters.in;

import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.kafka.annotation.KafkaListener;
import com.markswell.payment.adapters.out.message.SaleMessage;
import com.markswell.payment.application.ports.in.SalePaymentInputPort;

import static com.markswell.payment.application.core.domain.enums.SaleEvent.EXECUTE_PAYMENT;

@Slf4j
@Component
@RequiredArgsConstructor
public class ReceiveSaleToPaymentConsumer {

    private final SalePaymentInputPort salePaymentInputPort;

    @KafkaListener(topics = "tp-saga-payment", groupId = "payment")
    public void receive(SaleMessage saleMessage) {
        if(EXECUTE_PAYMENT.equals(saleMessage.getEvent())) {
            log.info("Payment start");
            salePaymentInputPort.payment(saleMessage.getSale());
            log.info("Payment finished");
        }
    }

}
