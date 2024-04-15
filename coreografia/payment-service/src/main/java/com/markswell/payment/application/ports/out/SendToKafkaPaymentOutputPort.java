package com.markswell.payment.application.ports.out;

import com.markswell.payment.application.core.domain.Sale;
import com.markswell.payment.application.core.domain.enums.SaleEvent;

public interface SendToKafkaPaymentOutputPort {

    void send(Sale sale, SaleEvent saleEvent);

}
