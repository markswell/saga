package com.markswell.orchestrator.application.ports.out;

import com.markswell.orchestrator.application.core.domain.Sale;
import com.markswell.orchestrator.application.core.domain.enums.SaleEvent;

public interface SendSaleToTopicOutputPort {

    void send(Sale sale, SaleEvent saleEvent, String topic);

}
