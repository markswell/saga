package com.markswell.saleservice.adapter.in.consumer;

import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.kafka.annotation.KafkaListener;
import com.markswell.saleservice.adapter.out.message.SaleMessage;
import com.markswell.saleservice.application.port.in.FinalizeSaleInputPort;

import static com.markswell.saleservice.application.core.domain.enums.SaleEvent.FINALIZE_SALE;

@Slf4j
@Component
@RequiredArgsConstructor
public class ReceiveSaleToFinalizeConsumer {

    private final FinalizeSaleInputPort finalizeSaleInputPort;

    @KafkaListener(topics = "tp-saga-sale", groupId = "sale-finalize")
    public void receive(SaleMessage saleMessage) {
        if(FINALIZE_SALE.equals(saleMessage.getEvent())) {
            log.info("Finalize sale start");
            finalizeSaleInputPort.finalize(saleMessage.getSale());
            log.info("Finalize sale finish");
        }
    }

}
