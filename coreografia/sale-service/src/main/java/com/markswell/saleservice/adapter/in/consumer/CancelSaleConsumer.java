package com.markswell.saleservice.adapter.in.consumer;

import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.kafka.annotation.KafkaListener;
import com.markswell.saleservice.adapter.out.message.SaleMessage;
import com.markswell.saleservice.application.port.in.CancelSaleInputport;

import static com.markswell.saleservice.application.core.domain.enums.SaleEvent.ROLLBACK_INVENTORY;

@Slf4j
@Component
@RequiredArgsConstructor
public class CancelSaleConsumer {

    private final CancelSaleInputport cancelSaleInputport;

    @KafkaListener(topics = "tp-saga-sale", groupId = "sale-cancel")
    public void receive(SaleMessage saleMessage) {
        if(ROLLBACK_INVENTORY.equals(saleMessage.getEvent())) {
            log.info("Cancel sale start");
            cancelSaleInputport.cancel(saleMessage.getSale());
            log.info("Cancel sale finish");
        }
    }

}
